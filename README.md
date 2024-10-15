This project is a comprehensive music studio management system that includes both backend and frontend components. The system is designed to manage various aspects of a music studio, including albums, musical instruments, users (musicians, producers, and administrators), and requests for albums and instruments. Additionally, it allows the scheduling and management of recording sessions.

Backend Overview:
The backend system is responsible for handling the core functionality of the application, including:

- Album Management: Create, store, and manage albums along with their associated producers.
- Instrument Management: Track and manage the studio's instrument inventory, including adding, removing, and tracking availability.
- User Management: Manage users such as musicians, producers, and administrators, with proper access control and role-based interactions.
- Request System: Allow users to submit requests for albums or instruments, with options to approve, reject, or view the status of these requests.
- Session Management: Schedule and manage recording sessions for musicians and producers, with the ability to filter sessions by date.
- Data Persistence: Support for reading and writing data to files, ensuring persistence across sessions.


Frontend Overview:
The frontend component interacts with the backend to provide an interface for users to:

- Log in as different types of users (musicians, producers, administrators).
- Manage albums, instruments, and sessions.
- View and submit requests for studio resources.
- Visualize and interact with available albums and sessions in a user-friendly manner.


Key Technologies:
- Java: The entire system is built in Java, leveraging object-oriented programming principles.
- File I/O and Serialization: Used to save and load objects such as users, albums, instruments, and sessions.
- CLI Interface: The frontend currently operates via a command-line interface (CLI), providing simple input and output functionality.
