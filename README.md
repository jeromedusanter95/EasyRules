# EasyRules

A Jetpack Compose Multiplatform application that provides a comprehensive collection of card and dice game rules. Never forget how to play your favorite games again!

## Overview

**EasyRules** is a mobile app designed to be your go-to reference for party games, card games, and dice games. Whether you're planning a game night with friends or trying to remember the rules of a classic card game, this app has you covered.

The app features a curated collection of **32 games** with detailed rules, setup instructions, and gameplay mechanics.

## Features

- **Extensive Game Library**: Browse through 32 different card and dice games
- **Detailed Game Rules**: Each game includes:
  - Goal and objective
  - Required materials
  - Setup instructions
  - How to play (step-by-step)
  - End conditions and scoring
  - Variants (when applicable)

- **Smart Filtering**: Find the perfect game for your situation
  - Filter by number of players
  - Filter by game duration (10-240 minutes)
  - Filter by difficulty level (Easy, Medium, Hard)
  - Filter by game type (Cards, Dice, No Material, Team, Elimination, Hidden Identity, Drinks, Tricks)

- **Search Functionality**: Quickly find games by name

- **Multi-language Support**: Available in English and French

- **Cross-Platform**: Runs on both Android and iOS devices

## Game Categories

Games are tagged with various categories to help you find what you're looking for:

- **Cards**: Traditional card games
- **Dice**: Games requiring dice
- **No Material**: Games that don't need physical materials
- **Team**: Cooperative or team-based games
- **Elimination**: Games where players are eliminated
- **Hidden Identity**: Games with secret roles or identities
- **Drinks**: Drinking games
- **Tricks**: Trick-taking card games

## Technology Stack

This project is built with modern mobile development technologies:

- **Kotlin Multiplatform**: Share code between Android and iOS
- **Jetpack Compose Multiplatform**: Modern declarative UI framework
- **Material 3**: Modern Material Design components
- **Navigation Compose**: Type-safe navigation
- **Compottie**: Lottie animations support
- **MVVM Architecture**: Clean architecture with ViewModel and use cases

### Supported Platforms

- **Android**: Minimum SDK 24 (Android 7.0), Target SDK 34
- **iOS**: Supports iOS devices (iPhone and iPad)

## Project Structure

```
/composeApp
  ├── src/
  │   ├── commonMain/       # Shared code for all platforms
  │   │   ├── kotlin/
  │   │   │   └── com/jeromedusanter/easyrules/
  │   │   │       ├── domain/         # Business logic, models, use cases
  │   │   │       └── ui/             # UI components, screens, ViewModels
  │   │   └── composeResources/       # Shared resources (images, strings)
  │   ├── androidMain/      # Android-specific code
  │   └── iosMain/          # iOS-specific code
  └── build.gradle.kts
/iosApp                     # iOS application entry point
```

## Building the Project

### Requirements

- JDK 11 or higher
- Android Studio Hedgehog or later
- Xcode 14+ (for iOS development)
- Kotlin 2.0.20

### Android

1. Open the project in Android Studio
2. Sync Gradle files
3. Run the `composeApp` configuration on an Android device or emulator

### iOS

1. Open `iosApp/iosApp.xcodeproj` in Xcode
2. Select your target device or simulator
3. Build and run the project

## Version

**Current Version**: 1.1 (Build 2)

## Development

The app follows clean architecture principles with clear separation of concerns:

- **Domain Layer**: Contains business logic, models, and use cases
- **UI Layer**: Compose UI components and ViewModels
- **Platform-Specific**: Platform implementations for Android and iOS

### Key Features Implementation

- **Game Filtering**: Real-time filtering based on multiple criteria
- **Search**: Instant search through game names
- **Localization**: Automatic language detection and content switching
- **Responsive UI**: Adapts to different screen sizes and orientations

## License

This project is a personal application showcasing game rules for educational and entertainment purposes.

## Author

Jerome Dusanter

---

**Note**: This app is a reference tool for learning and playing traditional card and dice games. No physical materials are provided with the app.