# **TP3 – STARS**

## **Image Processing in Java (PGM Format)**

by :


* Safa Bouzidi
* Oussama Kazoubi
* Imane Laasri

This repository contains the TP3 STARS assignment (EC-Nantes), implementing grayscale **PGM (P2)** image processing using **Java + Maven** with full collaborative workflow.

---

## 🗂 **Project Structure**

```
src/
 └── main/
      └── java/
           └── fr/ec_nantes/stars/
                ├── PgmImage.java
                ├── ImageOperations.java
                └── MainApp.java
pom.xml
baboon.pgm
coins.pgm
brain.pgm
```

---

## 🖼 **Features**

### ✔️ **PGM Handling**

* Load **P2** PGM images
* Skip blank lines & comments (`#`)
* Store **width**, **height**, **max gray**, **pixel matrix**
* Save PGM files with correct formatting

### ✔️ **Image Processing Operations**

* **Thresholding** (binary conversion)
* **Difference** between two PGM images
* **Scaling** (nearest-neighbor enlarge/reduce)

### ✔️ **Testing (MainApp)**

* Load PGM
* Save copy
* Threshold test
* Difference test
* Scaling test

---

## 🚧 **Upcoming Improvements**

* Histogram generation
* Swing-based GUI
* Full Javadoc

---

## 🚀 **Build & Run**

### **1️⃣ Build the Project**

Maven → **Lifecycle → package**

Produces the JAR:
`target/StarsImageProcessing-1.0-SNAPSHOT.jar`

### **2️⃣ Run**

```
java -jar target/StarsImageProcessing-1.0-SNAPSHOT.jar
```

Or run **MainApp.java** directly in IntelliJ.

---

## 📦 **Dependencies**

* **Java 22**
* Maven standard compiler & jar plugins
* **No external libraries**

---

## 👥 **Collaboration Workflow**

### 🔹 Team Members

  * Safa Bouzidi
  * Oussama Kazoubi
  * Imane Laasri

### 🔹 GitHub Issues

Tasks split into:

* PGM Reader / Writer
* Threshold
* Difference
* Scaling
* Testing
* Documentation

### 🔹 GitHub Project Board

Columns:

* **To Do**
* **In Progress**
* **Review**
* **Done**

### 🔹 Issue Assignments

Work distributed across team members for a fully collaborative workflow.

---

## 🛠 **Main Classes**

### **PgmImage.java**

* Read PGM
* Write PGM
* Store pixel data

### **ImageOperations.java**

* Threshold
* Difference
* Scaling

### **MainApp.java**

* Runs example operations for verification

---

## 📚 **Notes**

* Place PGM files in the same directory as `pom.xml` when running via IntelliJ.
* Difference operation requires images of identical dimensions.
* Scaling uses **nearest-neighbor** interpolation (per TP requirements).

---

## 🏁 **Status**

TP currently **in progress**.
