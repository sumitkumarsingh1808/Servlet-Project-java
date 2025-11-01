# 📘 Servlet-Project-Java

This project demonstrates **Java Database Connectivity (JDBC)**, **CRUD operations**, and the **MVC architecture** using **Servlets and JSP**.  
It connects to **MySQL databases** and allows users to manage data through interactive Java applications.

---

## 🚀 Features

- ✅ JDBC connection using `DriverManager`  
- ✅ Fetching employee details from the `Employee` table  
- ✅ Performing full CRUD operations on the `Product` table  
- ✅ Transaction handling to ensure data integrity  
- ✅ Servlet and JSP integration for user login and attendance tracking  
- ✅ Organized structure following MVC principles  

---

## 🧱 Project Structure

Servlet-Project-Java/
│
├── src/
│   ├── FetchEmployeeData.java       # Fetch all employees from Employee table
│   ├── ProductCRUD.java             # Perform CRUD operations on Product table
│
├── lib/
│   └── mysql-connector-j-9.5.0.jar  # MySQL JDBC driver
│
├── database.sql                     # Creates jdbc_project (Employee + Product)
├── productDB.sql                    # Creates productDB for CRUD operations
├── attendance.sql                   # (Optional) For student portal attendance
├── README.md                        # Project details and setup guide
│
└── WebContent/                      # (For Servlets & JSP)
    ├── index.html
    ├── login.jsp
    └── WEB-INF/
        └── web.xml

## 🧰 Requirements

Before running the project, ensure you have:

- ☕ **Java JDK 17 or higher** (recommended: JDK 21)
- 🗄️ **MySQL 8.0+**
- 🧠 **IntelliJ IDEA / Eclipse IDE**
- 🧩 **MySQL Connector JAR** (already included in `/lib`)

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/sumitkumarsingh1808/Servlet-Project-java.git
cd Servlet-Project-java
