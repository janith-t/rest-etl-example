# 🧩 REST ETL Example

This project — **rest-etl-example** — demonstrates a simple **ETL (Extract, Transform, Load)** process built with **Java Spring Boot**.  
It extracts data from a given REST endpoint, transforms it into entity objects, and loads it into a **MySQL** database.  
At the end of the process, it returns how many records were successfully saved.

---

## ☕ Overview

This project acts as a lightweight data ingestion service where:
- Data is **extracted** from a public API endpoint.
- Data is **transformed** into entity objects (`PersonEntity`).
- Data is **loaded** into a **MySQL** database using Spring Data JPA.

Each time the application runs, it uses **`spring.jpa.hibernate.ddl-auto=create-drop`**, which means:
> ⚠️ All existing data is dropped and new tables are created at startup — ideal for testing and learning.

---

## 🧩 Project Details

- **Project Name:** `rest-etl-example`
- **Technology Stack:** Java 17, Spring Boot, Spring Data JPA, MySQL
- **Repository:** [https://github.com/janith-t/rest-etl-example.git](https://github.com/janith-t/rest-etl-example.git)
- **Branch:** `dev`

---

## 🧠 Features

- Fetches JSON data from a configured REST endpoint
- Saves extracted records into MySQL
- Returns a response message showing how many records were inserted
- Automatically recreates the database schema on each run

---

## ⚙️ Prerequisites

Before running the project, make sure you have:
- **Java 17** (JDK 17 or above)
- **Maven 3.8+**
- **MySQL Server** (with credentials configured in `application.properties`)
- **An IDE** such as IntelliJ IDEA, Eclipse, or VS Code with Java Extensions

---

## ▶️ How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/janith-t/rest-etl-example.git
   cd rest-etl-example
   git checkout dev

### Access the API endpoint
**localhost:8001/api/users/extract**

This will extract data from the configured external source, save it into the database, and return a message like:


### © Copyright

© 2025 **Janith Thiwanka Payagala**  
All rights reserved.
