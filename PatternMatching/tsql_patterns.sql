-----------------------------------------------------------------------
-- Dangerous Function
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/dangerous_function_exec_ddl.html
-- Returning a list of executable files

EXEC master..xp_cmdshell 'dir *.exe'

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Returning no output

USE master;
EXEC xp_cmdshell 'copy c:\SQLbcks\AdvWorks.bck
    \\server2\backups\SQLbcks, NO_OUTPUT';
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using return status

DECLARE @result int;
EXEC @result = xp_cmdshell 'dir *.exe';
IF (@result = 0)
   PRINT 'Success'
ELSE
   PRINT 'Failure';

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Writing variable contents to a file

DECLARE @cmd sysname, @var sysname;
SET @var = 'Hello world';
SET @cmd = 'echo ' + @var + ' > var_out.txt';
EXEC master..xp_cmdshell @cmd;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Capturing the result of a command to a file

DECLARE @cmd sysname, @var sysname;
SET @var = 'dir/p';
SET @cmd = @var + ' > dir_out.txt';
EXEC master..xp_cmdshell @cmd;

-----------------------------------------------------------------------
-- Code Correctness: Erroneous Null Comparison
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/code_correctness_erroneous_null_comparison_plsql.html

SELECT * FROM MyTable WHERE MyColumn != NULL
SELECT * FROM MyTable WHERE MyColumn <> NULL
SELECT * FROM MyTable WHERE MyColumn IS NOT NULL

-----------------------------------------------------------------------
-- Unreleased Resource: Cursor Snarfing
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/unreleased_resource_cursor_snarfing.html

DECLARE Employee_Cursor CURSOR FOR
SELECT EmployeeID, Title FROM AdventureWorks2012.HumanResources.Employee;
OPEN Employee_Cursor;
FETCH NEXT FROM Employee_Cursor;
WHILE @@FETCH_STATUS = 0
   BEGIN
      FETCH NEXT FROM Employee_Cursor;
   END;
--CLOSE Employee_Cursor; is missing
--DEALLOCATE Employee_Cursor; is missing
GO

-----------------------------------------------------------------------
-- Empty try catch
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/poor_error_handling_empty_default_exception_handler.html

BEGIN TRY
    SELECT 1/0 AS DivideByZero
END TRY
BEGIN CATCH
END CATCH

-----------------------------------------------------------------------
-- Denial of Service
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/denial_of_service.html
-- An attacker could cause the program to crash or otherwise become unavailable to legitimate users.

CREATE PROCEDURE dbo.TimeDelay_hh_mm_ss @DelayLength char(8)
AS
BEGIN
WAITFOR DELAY @DelayLength;
END;

-----------------------------------------------------------------------
-- Insecure Randomness
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/insecure_randomness.html
SELECT RAND(100), RAND(), RAND()

-----------------------------------------------------------------------
-- Password Management: Empty Password
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/password_management.html
-- Empty passwords may compromise system security in a way that cannot be easily remedied.

CREATE PROCEDURE test_proc AS
DECLARE
    @pwd VARCHAR(20);
BEGIN
    SET @pwd = ''; -- empty
    SET @password = 'tiger'; -- hardcoded
    SET @password = null; -- null
END;

-----------------------------------------------------------------------
-- Password Management: Password in Comment
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/password_management_password_in_comment.html
-- Storing passwords or password details in plaintext anywhere in the system or system code may compromise system security in a way that cannot be easily remedied.

-- Default username for database connection is "scott"
-- Default password for database connection is "tiger"

-----------------------------------------------------------------------
-- Privilege Management: Overly Broad Grant
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/privilege_management_overly_broad_grant.html

GRANT ALL ON employees TO john_doe;

-----------------------------------------------------------------------
-- Weak Cryptographic Hash (MD2, MD4, MD5, RIPEMD-160, and SHA-1)
-- http://www.hpenterprisesecurity.com/vulncat/en/vulncat/sql/weak_cryptographic_hash.html

SELECT HashBytes('MD5', 'email@dot.com')
SELECT CONVERT(NVARCHAR(32), HashBytes('MD5', 'email@dot.com'),2)
