# YogGuru
Synopsis:

This project aims to develop a web application for managing yoga class admissions using Java servlets, HTML, CSS, and JSP, following the Model-View-Controller (MVC) architecture. The application allows users to enroll in monthly yoga classes, choose batches, and make payments.

Index Page
![image](https://github.com/sanskar1258/YogGuru/assets/154342944/8fbeab15-a53a-4e1a-8082-b12be3b148f5)


Key Components:

    Model (Java Classes):
        User Model: Represents user data such as name, age, phone, selected batch, and start date.
        Admission Service: Contains business logic for processing admissions, including validation and database interaction.

    View (HTML, CSS, JSP):
        Admission Form (HTML and CSS): Presents a user-friendly form for capturing user details, including name, age, phone, selected batch, and start date.
        Success and Error JSP Pages: Display success or error messages after processing user admissions.

    Controller (Servlets):
        Admission Controller (Servlet): Handles HTTP requests, retrieves form data, calls Admission Service for processing, and redirects to appropriate JSP pages based on the result.

    MVC Flow:
        User interacts with the Admission Form (View) presented in the web browser.
        Form data is submitted to the Admission Controller (Controller) via an HTTP request.
        The Admission Controller retrieves the data, validates it, and calls methods in the Admission Service (Model) for processing.
        The Admission Service interacts with the database to store user data.
        Based on the processing result, the user is redirected to Success or Error JSP pages (View).

    HTML and CSS:
        HTML is used for structuring the admission form and other pages.
        CSS is employed for styling and enhancing the visual presentation of the application.

    Database Interaction:
        MySQL database is used to persistently store user admission data.
        JDBC or an ORM (Object-Relational Mapping) framework is employed for database connectivity.

Deployment:

    The application can be deployed on a web server (e.g., Apache Tomcat).
    Cloud hosting services like Heroku or Netlify can be utilized for easy deployment.

Conclusion:

    This web application provides a user-friendly interface for yoga class admissions, adhering to the MVC architecture for better code organization, maintainability, and scalability.
