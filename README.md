<div align="center">
</br>
<img src="/screenshots/reddit-01.jpg"/>
</div>

</br>

<p align="center">
  <img src="https://forthebadge.com/images/badges/built-for-android.svg"><br>
   <img src="https://user-images.githubusercontent.com/57827233/136597211-06f60356-8aa3-494b-8c4b-189bd975c29f.jpg" width="320">
</p>
<p align="center">
  <img src="https://img.shields.io/github/repo-size/hiten24/compose-ui-templates">
  <img alt="GitHub" src="https://img.shields.io/github/license/hiten24/compose-ui-templates?color=blue">
</p>
<p align="center">
  <img src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white">
</p>

</br>

# Reddit (Task) 🔥
It is a task application using reddit api demonstrate best practices, provide a set of guidelines, and present modern Android application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and long application lifecycle management.

</br>

## Modularization 👨🏽‍💻
Modularization in Android development is a software architectural approach that involves breaking down a monolithic Android application into smaller, self-contained modules or components. Each module is responsible for specific functionality, features, or layers of the application, making the codebase more organized, maintainable, and scalable. Modularization is a critical aspect of modern Android app development, and it offers several benefits to developers and teams.
### Why Modularization Is Important
- __Code Organization__ : Modularization enables the organization of code into discrete modules, each with a specific responsibility. This makes it easier to find, read, and work with code, reducing complexity and improving code maintainability.
- __Scalability__ : As your app grows in complexity and size, modularization allows you to add new features or components without affecting the existing codebase. Developers can work on different modules concurrently, speeding up development.
- __Reusability__ : Modules can be reused across projects or shared between different parts of the same application. This reusability reduces redundant code and promotes consistency.
- __Testing__ : Modularization facilitates more focused and effective testing. Each module can be tested independently, which simplifies unit testing, integration testing, and debugging.
- __Team Collaboration__ : In larger development teams, modularization promotes collaboration. Different teams or developers can work on separate modules, reducing conflicts and parallelizing development efforts.
- __Reduced Build Times__ : Smaller, modularized components lead to faster build times, as changes in one module do not require rebuilding the entire application.
- __Maintenance__ : Debugging, maintenance, and updates are more straightforward in a modularized codebase. Isolating issues to specific modules simplifies the debugging process.

## Clean Architecture 👨🏽‍💻
Clean Architecture, inspired by Uncle Bob's Clean Architecture principles, advocates the separation of concerns in software development. It promotes the division of an app into distinct layers, each with a specific responsibility:
- __Entities__ : Represent core business models.
- __Use Cases (Interactors)__ : Contain application-specific business logic.
- __Repositories__ : Define abstract data source interfaces.
- __Data Sources__ : Implement concrete data source interactions.
- __Presentation__ : Contains the user interface (UI) layer.

In presentation layer (e.g., Activities and Fragments) adopts the " MVI pattern ". It observes the Model for state changes and updates the UI accordingly. User interactions are transformed into Intents, which are sent to the Use Cases to modify the Model.

By adopting Clean Architecture with the Model-View-Intent (MVI) pattern in my Android project, i've realized a multitude of benefits that have significantly improved my development process and app quality. Here are some of the key advantages i've experienced:

- __Separation of Concerns__ : Clean Architecture enforces a clear separation between business logic, data access, and UI. MVI ensures a unidirectional data flow within the UI layer.
- __Testability__ : Components are highly testable. Use Cases, in particular, are testable in isolation, and UI logic is easier to unit test.
- __Predictable State Management__ : MVI ensures that the UI's state is predictable and easy to reason about, reducing the chances of bugs and unexpected behavior.
- __Scalability__ : Clean Architecture makes it easier to add new features or scale the app. MVI simplifies managing complex UI logic.

</br>

## Dependency Management with Kotlin DSL in `build.gradle.kts`
Managing dependencies in an Android project is a crucial aspect of development, and Kotlin DSL (Domain Specific Language) in the build.gradle.kts file brings a host of advantages for a more concise and readable dependency management approach.
Kotlin DSL promotes a consistent and readable style for dependency declarations, leading to cleaner and more maintainable build scripts.

## Decoupling Components using HILT
Dependency Injection helps decouple classes by removing the responsibility of creating and managing dependencies from the dependent classes. This results in more modular and maintainable code.
