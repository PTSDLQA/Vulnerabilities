<?php
/**
  @licence GPL 2005-2011  The osCSS developers - osCSS Open Source E-commerce
  @portion code Copyright (c) 2002 osCommerce
  @package osCSS-2 <www http://www.oscss.org>
  @version 2.1.0
  @date  04/07/11, 10:14
  @author oscim <mail aurelien@oscim.fr> <www http://www.oscim.fr>
  @encode UTF-8
  \file
  \dir admin/includes/
  \brief is init file oscss core backoffice. the file is one file loaded
*/


  //! Start the clock for the page parse time log
  define('PAGE_PARSE_START_TIME', microtime());

  //! Path relatif si applé par block module ou autre
  $rpa = (defined('RELATIVE_PATH_ACTIVE'))? RELATIVE_PATH_ACTIVE: '';

  //! Set the local configuration parameters - mainly for developers
  if (file_exists($rpa.'includes/local/configure.php')) include($rpa.'includes/local/configure.php');
  else require($rpa.'includes/configure.php');

  // force config in object, by stdclass
  $conf = (object)$conf;

  //!Set the level of error reporting
  ((OSCSS_DEBUG==true)? error_reporting(-1) : error_reporting(0) );

  //! gestionnaire d'erreur
  if(OSCSS_GARBAGE_ERROR==true) {
	  include($rpa.DIR_WS_CLASSES.'osC_ErrorHandler.php');
	  $errorHandler = osC_ErrorHandler::start();
	  if(OSCSS_DEBUG==true) $errorHandler->attach($mock=new MockWriter());

    //! init Exception
    set_exception_handler('exception_handler');
  }


  //! include the list of project filenames
  require($rpa.DIR_WS_INCLUDES . 'filenames.php');

  //! include the list of project database tables
  require($rpa.DIR_WS_INCLUDES . 'database_tables.php');

/// include  list of project class and lib permanente
  include($rpa.DIR_WS_INCLUDES . 'inc_base_lib_min.php');

  //! var init
  $page_admin=(isset($_GET['page_admin']) || !empty($_GET['page_admin']) ) ? tep_sanitize_string($_GET['page_admin']) : 'index';
  $action = (isset($_GET['action'])) ? tep_sanitize_string($_GET['action']) : '';

  //! set php_self in the local scope
  $PHP_SELF = (isset($_SERVER['PHP_SELF']) ? $_SERVER['PHP_SELF'] : $_SERVER['SCRIPT_NAME']);

// Define how do we update currency exchange rates
// Possible values are 'oanda' 'xe' or ''
  define('CURRENCY_SERVER_PRIMARY', 'oanda');
  define('CURRENCY_SERVER_BACKUP', 'xe');

/// make a connection to the database... now
  $DB=Database::getInstance();

  //! element optionnel
  if (file_exists($rpa.DIR_WS_INCLUDES . 'tables_files_modules.php')) require($rpa.DIR_WS_INCLUDES . 'tables_files_modules.php');

  //! set application wide parameters
  $res=$DB->query('select configuration_key as cfgKey, configuration_value as cfgValue from ' . TABLE_CONFIGURATION .' where configuration_type IN ("1","2") ');
  while ($configuration = $res->fetchAssoc())
    define(strtoupper($configuration['cfgKey']), $configuration['cfgValue']);

  //! attach  file erreor log
  if(OSCSS_GARBAGE_ERROR==true) {
    if (_cst_bool('STORE_PAGE_PARSE_STOCK_ERROR')){
      $file=( (getenv('HTTPS') == 'on')? 'err-php-ssl' : 'err-php' );
      $errorHandler->attachFileWriter($rpa.DIR_WS_INCLUDES.'tmp/'.$file.'.log');
    }
    if (_cst_bool('STORE_PAGE_PARSE_EMAIL_OWNER')) $errorHandler->attachMailWriter(STORE_OWNER_EMAIL_ADDRESS);
  }

  /// define the project version
  define('PROJECT_VERSION', get_info_core(DIR_FS_CATALOG. DIR_WS_COMMON.'oscss.version.xml','version').' - svn '.get_info_core(DIR_FS_CATALOG. DIR_WS_COMMON.'oscss.version.xml','svn'));

/// include  list of project class and lib permanente
  include($rpa.DIR_WS_INCLUDES . 'inc_base_lib.php');

  //! initialize the cache class
  $osCSS_Cache = new osCSS_Cache();

  /// init price
  $osC_Tax=$price=$currencies = new price();

  //! récupére la MASTER VALUE de 'session.save_path'
  define('PHP_SESSION_SAVE_PATH_MASTER', ini_get('session.save_path'));

  //! set the session name and save path
  tep_session_name('osCAdminID');
  tep_session_save_path();

  //! active le garbage collector de PHP si nécessaire
  if (tep_session_save_path() != PHP_SESSION_SAVE_PATH_MASTER){
    ini_set('session.gc_maxlifetime', SESSION_LIFE_ADMIN*60);
    ini_set('session.gc_probability', '50');
    ini_set('session.gc_divisor', '100');
  }

/// set the session cookie parameters
  if (function_exists('session_set_cookie_params')) session_set_cookie_params(0, DIR_WS_ADMIN);
  elseif (function_exists('ini_set')) {
    ini_set('session.cookie_lifetime', '0');
    ini_set('session.cookie_path', DIR_WS_ADMIN);
  }

/// lets start our session
  tep_session_start();

/// Gestion de gabarit appel langue specifique a la page
  $page_admin=(isset($page_admin) || !empty($page_admin) ) ? $page_admin : (($_SERVER['REQUEST_URI'] !='index')?substr(basename($_SERVER['REQUEST_URI']),0,-4) : 'index');
  $current_page = $page_admin.'.php';

/// navigation history
  if (!tep_session_is_registered('navigation')) {
    tep_session_register('navigation');
    $navigation = new navigationHistory;
  }

/// Admin begin
  if (!in_array($current_page, array('cronfile.php')) ) tep_admin_check_login();


/// set the language
  if (!tep_session_is_registered('language') || isset($_GET['language'])) {
    if (!tep_session_is_registered('language')) {
      tep_session_register('language');
      tep_session_register('languages_id');
      tep_session_register('language_code2');
      tep_session_register('language_iso');
    }

    $lng = new language();

    if (isset($_GET['language']) && tep_not_null($_GET['language']))   $lng->set_language(tep_sanitize_string($_GET['language']));
    else   $lng->get_browser_language();

    $language = $lng->language['directory'];
    $language_code2 = $lng->language['directory_code2'];
    $language_iso = $lng->language['code'];
    $languages_id = $lng->language['id'];
  }

//! Class chargeur/constructeur
 $oscss=oscss_cstr::getInstance();
 $oscss->add_var('language',$language);
 $oscss->add_var('languages_id',$languages_id);
 $oscss->add_var('language_iso_long',$language_code2);
 $oscss->add_var('language_iso',$language_code2);

 $oscss->cache_lang();

/// include the language translations
  if(oscss_cstr::TestFile($rpa.DIR_WS_LANGUAGES .$language .'/'. $language . '.php')) require($rpa.DIR_WS_LANGUAGES . $language .'/'. $language.'.php');

  //! Page en module
  if(oscss_cstr::TestFile(DIR_WS_MODULES.'pages/'.$current_page)) {
    $page_module=$page_admin;
    $page_admin='page';

    $oscss->pile_file_lang($rpa.DIR_WS_LANGUAGES . $language . '/modules/pages/'.$page_module.'.txt');

  } else {
  	$page_module=$page_admin;
  //! page en content
    if (oscss_cstr::TestFile(DIR_WS_LANGUAGES . $language . '/' . $current_page))  require($rpa.DIR_WS_LANGUAGES . $language . '/' . $current_page);
    elseif(oscss_cstr::TestFile(DIR_WS_LANGUAGES .  'fr_FR/' . $current_page))  require($rpa.DIR_WS_LANGUAGES .  'fr_FR/' . $current_page);

    $oscss->pile_file_lang($rpa.DIR_WS_LANGUAGES . $language . '/'.$page_admin.'.txt');
  }


/// sortie
  if (in_array($current_page, array('cronfile.php')) ) return ;

/// lib specifique a la page
  if (oscss_cstr::TestFile(DIR_WS_FUNCTIONS . 'lib.' . $current_page)) require(DIR_WS_FUNCTIONS . 'lib.' . $current_page );

/// initialize the message stack for output messages
  $messageStack = messageStack::getInstance();

/// calculate category path
  if (isset($_GET['cPath'])) $cPath = tep_sanitize_string($_GET['cPath']);
  else  $cPath = '';

  if (tep_not_null($cPath)) {
    $cPath_array = tep_parse_category_path($cPath);
    $cPath = implode('_', $cPath_array);
    $current_category_id = $cPath_array[(sizeof($cPath_array)-1)];
  } else {
    $current_category_id = 0;
  }


///this is for admin themes
  if (!isset($_GET['menu_theme']) && isset($_COOKIE['menu_theme'])) $current_theme = $_COOKIE['menu_theme'] ;
  else {
    $current_theme = (isset($_GET['menu_theme']) ? tep_sanitize_string($_GET['menu_theme']) : get_info_core(DIR_FS_CATALOG. DIR_WS_COMMON.'oscss.version.xml','template_admin'));
    setcookie('menu_theme', $current_theme , time()+31536000);
  }

/// definiton template path
  if(is_dir(DIR_WS_INCLUDES . "template/".$current_theme.'/')) define('DIR_WS_TEMPLATE', DIR_WS_INCLUDES . "template/".$current_theme.'/');
  else define('DIR_WS_TEMPLATE', DIR_WS_INCLUDES . 'template/defaut/');


/// language template
  if(oscss_cstr::TestFile($rpa.DIR_WS_TEMPLATE .'languages/'. $language . '.txt')) require($rpa.DIR_WS_TEMPLATE .'languages/'. $language . '.txt');

/// definiton
  $languages = tep_get_languages();
  $languages_array = array();
  $languages_selected = DEFAULT_LANGUAGE;

/// Checkup systeme
  if (_cst_bool('CHECKUP_WARN')) new checkupSys;

/// Element modulaire aca
//   require ($rpa.DIR_WS_CLASSES.'aca.generic.php');
//   $generic_modules = new generic();
  $generic_modules = new AcaFactory('generic');

/// Definition pour gestion affichage
  if (isset($_GET['row_by_page'])){
    $row_by_page=tep_sanitize_string($_GET['row_by_page']);
    define('MAX_DISPLAY_ROW_BY_PAGE' , tep_sanitize_string($_GET['row_by_page'] )) ;
  }else {
    $row_by_page = 10; //MAX_DISPLAY_SEARCH_RESULTS;
    define('MAX_DISPLAY_ROW_BY_PAGE' , 10 /*MAX_DISPLAY_SEARCH_RESULTS*/ );
  }
  $row_bypage_array = array(array('id' => 10, 'text' => 10));
  for ($i = 10; $i <=100 ; $i=$i+25)  $row_bypage_array[] = array('id' => $i, 'text' => $i);
  $row_by_page=(isset($_GET['row_by_page'])) ? tep_sanitize_string($_GET['row_by_page']) : 10;
  $page=(isset($_GET['page'])) ? tep_sanitize_string($_GET['page']) : 1;


//! specific quick search in BO
  if(isset($_POST['SearchSpeed'])){
    if($_REQUEST['sSearch'] !='') tep_redirect(tep_href_link($_REQUEST['SearchSpeed'].'.php','sSearch='.$_REQUEST['sSearch']));
    else tep_redirect(tep_href_link($_REQUEST['SearchSpeed'].'.php'));
  }

///
  oscss_cstr::afterAppliTop();
?>