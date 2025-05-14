# Bimm KMP Take Home Assignment - Base repo

IMPORTANT: Don't create a PR to this repo with your solution.

# Assignment instructions
You should have received a separate description for your assignment. If you haven't, please contact the member of the hiring team you're in touch with.

Also please verify you have received any files (JSON, xml, csv, txt, images, depending on the assignment) or any API addresses you assignment mentions. Those vary with the position you're applying to.


# Assignment deliver instructions
[Fork](https://github.com/reul/bimm-kmp-challenge-base/fork) or clone this repo and add the necessary code to complete your assignment, then email us with the link of the forked repo or to a zip or tarball file we can download and evaluate.

It's very important that we can run the project and see it being executed ourselves, so don't make it dependent on any private repos or environment variables we might not have access to or, if you must, include an APK in the tarball or in a GitHub release in your fork. Don't forget to include or stage any other dependencies (like json files).

## Build instructions
This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

