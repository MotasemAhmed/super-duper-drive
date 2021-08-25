# Super*Duper*Drive Cloud Storage

1. **Simple File Storage:** Upload/download/remove files
2. **Note Management:** Add/update/remove text notes
3. **Password Management:** Save, edit, and delete website credentials.  

##Roadmap

1. The back-end with Spring Boot
2. The front-end with Thymeleaf
3. Application tests with Selenium

### The Back-End
The back-end is all about security and connecting the front-end to database data and actions. 

1. Managing user access with Spring Security

2. Handling front-end calls with controllers

3. Making calls to the database with MyBatis mappers

### The Front-End

1. Login page

2. Sign Up page

3. Home page
 i. Files
 ii. Notes
 iii. Credentials

### Testing

1. tests for user signup, login, and unauthorized access restrictions.
 - a test that verifies that an unauthorized user can only access the login and signup pages.
 - a test that signs up a new user, logs in, verifies that the home page is accessible, logs out, and verifies that the home page is no longer accessible. 


2. tests for note creation, viewing, editing, and deletion.
 - a test that creates a note, and verifies it is displayed.
 - a test that edits an existing note and verifies that the changes are displayed.
 - a test that deletes a note and verifies that the note is no longer displayed.


3. tests for credential creation, viewing, editing, and deletion.
 - a test that creates a set of credentials, verifies that they are displayed, and verifies that the displayed password is encrypted.
 - a test that views an existing set of credentials, verifies that the viewable password is unencrypted, edits the credentials, and verifies that the changes are displayed.
 - a test that deletes an existing set of credentials and verifies that the credentials are no longer displayed.

