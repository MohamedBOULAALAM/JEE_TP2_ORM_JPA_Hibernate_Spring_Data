# 🏥 AP2 - ORM JPA Hibernate Spring Data

> Activité Pratique N°2 – Gestion des Patients avec Spring Boot, JPA, Hibernate et H2 Database

---

## 📌 Objectif du projet

Créer une application Java Spring Boot permettant de gérer les patients dans un système médical simple, en utilisant les outils suivants :

- Spring Data JPA pour le mapping objet-relationnel
- Hibernate comme moteur ORM
- H2 comme base de données en mémoire
- Lombok pour simplifier le code Java

---

## 🛠️ Technologies utilisées

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Lombok
- IntelliJ IDEA Ultimate

---

## ✅ Étapes réalisées

### 🧱 1. Entité JPA : `Patient`

Nous avons créé une classe `Patient` annotée avec `@Entity` représentant un patient avec les attributs suivants :

- `id : Long`
- `nom : String`
- `dateNaissance : Date`
- `malade : boolean`
- `score : int`

*Capture de l’entité `Patient.java` :*

![patient](Screens/patient.png)

---

### 🛠️ 2. Configuration de la base de données H2

La configuration a été placée dans le fichier `application.properties`, avec activation de la console H2.

*Configuration H2 :*

![application.properties](Screens/propapp1.png)

![localh2](Screens/localh2.png)

---

### 📂 3. Création de `PatientRepository`

Interface basée sur `JpaRepository<Patient, Long>` qui permet d’effectuer toutes les opérations CRUD, ainsi que des méthodes personnalisées comme :

- `findByMalade(boolean malade)`
- `findByNomContains(String keyword)`

*Capture de `PatientRepository.java` :*

![patientrepo1](Screens/patientrepo1.png)

---

### 🚀 4. Classe principale : insertion et affichage

Nous avons utilisé `CommandLineRunner` pour insérer des patients, les afficher, les modifier et en supprimer un.

*Extrait du code d’exécution dans `OrmJpaHibernateSpringDataApplication.java` :*

![proapp1](Screens/test1.png)

---

### ✅ 5. Résultats de l’exécution

- Insertion des patients : Mohamed, Imane, Karim
- Affichage en console
- Modification du score du patient n°1
- Suppression du patient n°2

*Résultat d’exécution dans la console :*

![Résultat du test1](Screens/restest1.png)


---

### 🧪 6. Résultat fonctionnel

L’application démarre sans erreurs, les entités sont bien mappées, la base de données est initialisée automatiquement, et les opérations sur les patients s’exécutent correctement.

---

### 🔁 7. Migration de H2 vers MySQL

Afin de rendre les données persistantes, nous avons remplacé la base H2 par **MySQL**.

#### ⚙️ a) Nouvelle configuration dans `application.properties`

Nous avons modifié la configuration pour pointer vers MySQL, avec création automatique de la base de données si elle n'existe pas.

*Capture de la configuration MySQL dans le fichier `application.properties` :*

![Configuration MySQL](Screens/propapp2.png)

---

#### 📊 b) Résultat dans phpMyAdmin

Sans modifier le code Java, simplement en relançant l'application avec la nouvelle configuration, Spring Boot a automatiquement :

- Créé la base `hospital_db` dans MySQL
- Généré la table `patient`
- Inséré les données initiales de test depuis le `CommandLineRunner`

*Table `patient` créée automatiquement dans MySQL avec les données :*

![Table Patient dans MySQL](Screens/mysql.png)

---

### ✅ 8. Bilan

Grâce à cette migration, les données ne sont plus perdues à chaque redémarrage de l'application.  
Cette configuration est mieux adaptée pour un usage réel en production.

---

### 🧩 9. Extension du modèle : Médecins, Rendez-vous, Consultations

Dans cette étape, nous avons enrichi notre application pour modéliser un système médical complet en ajoutant les entités suivantes :

#### 📌 Nouvelles entités créées :
- `Medecin` : représente un médecin avec un nom et une spécialité.
- `RendezVous` : représente un rendez-vous entre un patient et un médecin, avec un statut (`PENDING`, `DONE`, `CANCELED`) et une date.
- `Consultation` : représente le rapport médical lié à un rendez-vous.

#### 🔗 Relations JPA implémentées :
- `RendezVous` → `Patient` (ManyToOne)
- `RendezVous` → `Medecin` (ManyToOne)
- `Consultation` → `RendezVous` (OneToOne)


#### 💾 Repositories créés :
- `MedecinRepository`
- `RendezVousRepository`
- `ConsultationRepository`

#### 🧪 Insertion de données avec CommandLineRunner :
À l'exécution, l'application insère automatiquement :
- des patients
- des médecins
- des rendez-vous (ID générés par `UUID.randomUUID().toString()`)
- une consultation liée à un rendez-vous


---
## 🧑‍💻 Auteur
- **Nom :** Mohamed BOULAALAM 
- **École :** ENSET Mohammedia
- **Filière :** Ingénierie Informatique – Big Data & Cloud Computing


