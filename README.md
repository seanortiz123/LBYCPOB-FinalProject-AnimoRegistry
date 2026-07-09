# AnimoRegistry: A Centralized One-Stop Application for De La Salle University Students and Organization Recruitment Management

### TEAM MEMBERS:
1. Johanna Rae C. Castor  - johannacastor
2. Gian Gabriel S. Fadriquela - gianfadriquela-collab
3. Sean Matthew E. Ortiz - seanortiz123

### PROBLEM STATEMENT & GOALS:
There are currently no DLSU website that focuses on the recruitment process of organizations. This project aims to create a website that can help organizations recruit new members and students join organizations

### TARGET USER:
- DLSU Students who wants to join an organization
- DLSU Organizations who wants to recruit new members

### BRIEF DESCRIPTION:
The students looking to join an organization can navigate through the website to find which organizations are aligned with their interests. DLSU organizations can add their information and how to join using the website to recruit and manage new members. 

### CORE OOP CONCEPTS:
- Encapsulation:
  
DLSU Email Validation: 
The system encapsulates the email field. A user cannot just type any Gmail address. The setter method checks if the string ends strictly with @dlsu.edu.ph. If it doesn't, it rejects the sign-up.

ID Number Verification:
The class encapsulates this validation logic inside the setIdNumber() method, ensuring invalid IDs never enter the system

- Inheritance: 

Parent Class (DLSUUser): An abstract class that stores data every single Lasallian shares upon signing up (idNumber, name, dlsuEmail, password).
Child Class (LasallianStudent): Inherits from DLSUUser but asks for student-specific registration data, like their DLSU college (e.g., CCS, COB, CLA) and year level.
Child Class (OrgOfficer): Inherits from DLSUUser but requires org-specific data, like which student organization they represent (e.g., LSCS, animo.sys, Green Media Group) and their executive position.

- Polymorphism: displayDashboard() for Applicant and Organization Officer
- Abstraction: paymentMethod() for each organization's membership fee, implemented by Cash or DigitalBank
  
### INITIAL CLASS IDEAS:
- User (Abstract): Handles basic DLSU credentials, authentication, and core profile attributes.
- Applicant: Tracks submitted applications and interview schedules
- Organization: Holds student group details, recruitment slots, and active applicants 	
- ApplicationForm: Manages pending applications and interview answers			

### USER STORIES:
(Student)
- As a DLSU student, I want a one-stop app where I get to see all the available DLSU organizations/clubs that I am able to join
- As a DLSU student, I want a one-stop app where I'm able to input different needed information for my organization applications like my ID number and DLSU email
- As a Frosh or Undergraduate student, I want to track the real-time status of my submitted applications (e.g., Pending, Interview Scheduled, Accepted, Rejected) on a personal dashboard so that I know exactly where I stand in the recruitment process.


(Organization)
- As an Organization officer, I want an app where I am able to view different student applications and be able to accept or deny them.
- As an Executive Board Member, I want to toggle our organization's registration status to "Closed" once the recruitment season is done so that students can no longer submit new sign-up forms.
- As an Org Officer, I want to set a maximum membership cap for our specific committee during setup so that the app automatically stops accepting new applicants once our slots are completely filled.
- As a Central Committee Member, I want to edit our organization's profile page (such as updating our logo, social media handles, or org description) so that our digital booth display remains accurate for incoming frosh.

### CORE FEATURES (Recommended):
- Several webpages to navigate through each organization
- DLSU organizations able to add their own page and manage applicants
- Students able to join organization from the page of the organization
