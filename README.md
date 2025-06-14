# Music Studio Management System

A **Java‑based, file‑backed CLI application** for managing the day‑to‑day operations of a small music studio.  It supports producers, musicians and an administrator throughout the full production cycle – from scheduling sessions to tracking instrument inventory and publishing finished albums.

---

## ✨ Key Features

| Domain                     | What you can do                                                                                                                            |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| **Authentication & Roles** | Login as **Administrator**, **Producer** or **Musician** with role‑specific menus and authorisation checks                                 |
| **Album Workflow**         | • Request new albums• Add tracks / musicians to an album• Track production status (in‑progress / finished)                                 |
| **Session Scheduling**     | • Create, edit or cancel recording sessions• Associate sessions with albums and musicians• Calendar view & filters (per day, per producer) |
| **Instrument Inventory**   | • Add / remove instruments• Automatic availability tracking• Musicians can submit rental requests                                          |
| **Request Management**     | Admin dashboard to approve / reject album & instrument requests                                                                            |
| **Statistics**             | Real‑time studio KPIs: albums in production, completed sessions, etc., with monthly filters                                                |
| **Persistence**            | Transparent file‑based serialisation – all data lives across restarts, no external DB required                                             |

---

## 🏗️ Architecture

```
└── src
    ├── backend   ← Pure domain logic (entities & lists)
    │   ├── Album.java
    │   ├── Instrumento.java
    │   └── …
    └── frontend  ← CLI (Programa.java) – orchestrates user flow
```

* **Entities** – `Album`, `Musica`, `Instrumento`, `Sessao`, `Requisicao`, `Utilizador` (abstract) with concrete subclasses `Administrador`, `Produtor`, `Musico`.
* **Repository‑like Lists** – `ListaXYZ` classes provide CRUD, search helpers and handle Java **`Object{Input,Output}Stream`** serialisation (`*.dat` files).  No external libraries.
* **Frontend** – a single `Programa` class exposes hierarchical text menus; methods are grouped by role and feature area.

---

## ⚙️ Tech Stack & Conventions

| Layer       | Choice                                           |
| ----------- | ------------------------------------------------ |
| Language    | Java 17 (works on ≥ Java 8)                      |
| Build tool  | None – plain `javac` / any IDE                   |
| Persistence | Java built‑in serialisation to `*.dat` files     |
| UI          | Command‑Line Interface (System.in / System.out)  |
| Paradigms   | Object‑Oriented Programming, MVC‑lite separation |

---

## 🚀 Getting Started

### 1. Clone & Compile

```bash
$ git clone https://github.com/ppires21/music‑studio.git
$ cd music‑studio
$ javac -d bin $(find src -name "*.java")
```

> Or simply open *src/* in IntelliJ IDEA / Eclipse and hit **Run**.

### 2. Run

```bash
$ java -cp bin frontend.Programa
```

On first launch an *Administrator* account is auto‑seeded: **user:** `admin` – **pass:** `passwd`.

### 3. Data Files

All persistent data is stored alongside the executable:

```
Albuns.dat  Instrumentos.dat  Musicas.dat  Requisicoes.dat  Sessoes.dat  Utilizadores.dat
```

Delete these files to *factory‑reset* the application.

---

## 🗂️ Typical Workflow (CLI)

1. **Admin** logs in → approves a producer’s album request.
2. **Producer**

   1. creates recording sessions for the new album,
   2. adds musicians & tracks.
3. **Musicians** view their session calendar and request instruments.
4. **Admin** approves instrument rentals; inventory counts adjust automatically.
5. **Producer** marks sessions as *completed* → album progress statistics update.

---

## 📈 Roadmap

* Made in my free time during Christmas 2022 for a school project. 
* Duration: 3/4 weeks, including learning some concepts.
