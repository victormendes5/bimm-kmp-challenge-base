# Bimm KMP Take Home Assignment

A Kotlin Multiplatform (KMP) project designed to streamline cross-platform development for Android and iOS using Jetpack Compose and shared business logic.

---

## 🚀 Features

- **Kotlin Multiplatform (KMP):** Share business logic across Android and iOS platforms.
- **Jetpack Compose:** Utilize declarative UI for Android and Compose Multiplatform for shared UI.
- **Shared ViewModels:** Implement shared ViewModels for consistent state management.
- **Coroutines & Flow:** Handle asynchronous operations seamlessly.
- **Ktor Client:** Perform network operations efficiently.
- **Multiplatform Settings:** Handle key-value storage across platforms.
- **Dependency Injection:** Manage dependencies using Koin.

---

## 📁 Project Structure

```
.
├── androidApp/           # Android-specific code and resources
├── iosApp/               # iOS-specific code and resources
├── composeApp/           # Shared Kotlin Multiplatform UI and logic
│   ├── commonMain/       # Shared business logic, UI, models, utils
│   ├── androidMain/      # Android-specific implementations
│   ├── iosMain/          # iOS-specific implementations
├── build.gradle.kts      # Project-level Gradle configuration
└── settings.gradle.kts   # Gradle settings
```

---

## 🛠️ Getting Started

> ℹ️ This project was originally designed to use a static `sakeshop.json` file for shop data. Instead, I implemented a live mock API using [Apiary.io](https://apiary.io).  
> The app fetches data from: [`https://private-4ab845-test11663.apiary-mock.com/sakeshop`](https://private-4ab845-test11663.apiary-mock.com/sakeshop)

### Prerequisites

- **Android Studio Giraffe or later** with Kotlin Multiplatform support.
- **Xcode 14 or later** for iOS development.
- **Kotlin Multiplatform Mobile (KMM) plugin** for Android Studio.

### Clone the Repository

```bash
git clone https://github.com/victormendes5/bimm-kmp-challenge-base.git
cd bimm-kmp-challenge-base
```

### Run on Android

1. Open the project in Android Studio.
2. Select the `androidApp` configuration.
3. Click **Run** to build and deploy on an Android device or emulator.

### Run on iOS

1. Run:
   ```bash
   ./gradlew tasks | grep framework
   ```
2. Open `iosApp/iosApp.xcworkspace` in Xcode.
3. Add `ComposeAppShared.xcframework` to your Xcode project.
4. Select a simulator or device.
5. Click **Run**.

---

## 🧪 Testing

The project includes unit tests for shared modules.

To run tests:

```bash
./gradlew :composeApp:allTests
```

---

## 🖼 Image Loading Strategy

| Platform | Loader                                      |
|----------|---------------------------------------------|
| Android  | Coil 3 (`rememberAsyncImagePainter`)        |
| iOS      | Kamel (`asyncPainterResource`)              |

All image loading is handled through a shared `rememberImagePainter(url)` implementation using `expect/actual`.
Fallback placeholders are used on loading and failure.
