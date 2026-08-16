## How can I ensure that my code, program, or software is functional and secure?

I can ensure that my software is functional by testing requirements throughout development instead of waiting until the end. In this course, I used JUnit testing to check valid inputs, invalid inputs, boundary values, null values, duplicate IDs, and exceptions. I also used code coverage to confirm that most of my code was actually being exercised by my tests. Security also requires thinking about how unexpected or invalid information is handled instead of assuming users will always enter the correct data. Continuing to test, review code, and rerun regression tests after changes can help catch problems before software is released.

## How do I interpret user needs and incorporate them into a program?

I interpret user needs by first turning the customer's requirements into specific rules that the program must follow. For example, the Contact Service had requirements for ID length, names, phone numbers, addresses, and unique contact IDs. I used those requirements when creating both the program and the tests. I think it is important not to assume what the user wants when requirements are available. Breaking requirements into smaller pieces makes them easier to implement and gives me something specific to test against.

## How do I approach designing software?

I approach software design by breaking a larger problem into smaller classes, methods, and responsibilities. I try to keep the code simple, readable, and easy to test. During this course, separating the Contact, Task, and Appointment objects from their service classes made it easier to test each part individually. I also try to think about both normal and unexpected situations while designing software. Writing software with testing and maintainability in mind from the beginning can help reduce defects and technical debt later.
