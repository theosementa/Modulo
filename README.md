# Modulo

[![App Store](https://img.shields.io/badge/App%20Store-0D96F6?logo=app-store&logoColor=white)](https://apps.apple.com/us/app/modulo-track-your-savings/id6759111993)
![Kotlin](https://img.shields.io/badge/Kotlin_Multiplatform-2.x-7F52FF?logo=kotlin&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-17%2B-000000?logo=apple&logoColor=white)
![Android](https://img.shields.io/badge/Android-coming_soon-3DDC84?logo=android&logoColor=white)
[![Build Status](https://app.bitrise.io/app/790a9c9c-63dd-4af3-bc6a-93f0a11dc921/status.svg?token=bUwSdF9KdJXfDBG9kyq0kA&branch=develop)](https://app.bitrise.io/app/790a9c9c-63dd-4af3-bc6a-93f0a11dc921)
![SonarQube](https://img.shields.io/badge/SonarQube-Analyzed-4E9BCD?logo=sonarqube&logoColor=white)
[![Roadmap](https://img.shields.io/badge/Roadmap-GitHub%20Projects-34C759?logo=github)](https://github.com/theosementa/modulo-ios/projects)
[![Figma](https://img.shields.io/badge/Figma-Design-F24E1E?logo=figma&logoColor=white)](https://www.figma.com/design/uTGmdDAvUopqBAdL5VSC8o/Modulo-v2?node-id=1-5&t=QwxXDSNasY1lKJvw-1)
[![License: PolyForm NC](https://img.shields.io/badge/License-PolyForm%20NC%201.0-lightgrey)](./LICENSE)

> A clean, focused savings tracker — set goals, log contributions, and watch your progress over time.

> 🧪 **App available on iOS!** Try the latest version on [Apple Store](https://apps.apple.com/us/app/modulo-track-your-savings/id6759111993). Android is on its way.

---

## Features

- **Multi-goal tracking** — Create as many savings goals as you need, each with a target amount and optional deadline
- **Contributions** — Log deposits and withdrawals per goal, with an optional label and date
- **Charts** — Visualize your monthly net contributions over time with an interactive line chart
- **Cloud Sync** — Your data syncs automatically across your devices
- **Customization** — Choose your accent theme color and toggle haptic feedback
- **🤖 Local AI** *(coming soon)* — On-device AI integration to give you insights on your savings

---

## Screenshots

<img width="1920" height="1440" alt="803_1x_shots_so" src="https://github.com/user-attachments/assets/f16f0593-f408-4a23-8097-f927c4f0a36c" />

---

## Tech Stack

Modulo is built with **Kotlin Multiplatform (KMP)** — business logic is shared across iOS and Android, while each platform keeps its own native UI.

### Shared (KMP)

| | |
|---|---|
| **Language** | Kotlin |
| **Persistence** | Room (KMP) |
| **Networking** | Ktor |
| **Architecture** | Clean Architecture — Domain / Repository / Store / Provider |

### iOS

| | |
|---|---|
| **Language** | Swift 6.1 |
| **UI** | SwiftUI |
| **Code Quality** | SwiftLint · SonarQube · MobSF |

### Android

| | |
|---|---|
| **Language** | Kotlin |
| **UI** | Jetpack Compose |

---

## Architecture

Business logic lives entirely in the shared KMP module. Each platform consumes it through a native UI layer with no shared UI code — SwiftUI on iOS, Jetpack Compose on Android.

```
[Shared KMP module]
Domain → Repository → Store → Provider

[iOS]                        [Android]
SwiftUI Views                Compose UI
    ↕                            ↕
    └──────── KMP logic ─────────┘
```

The shared module is structured as:

```
shared/
├── domain/        # Models, use cases
├── repository/    # Data access interfaces + implementations (Room, Ktor)
├── store/         # State holders
└── provider/      # Business logic exposed to UI layers
```

See [CLAUDE.md](./CLAUDE.md) for a detailed breakdown of conventions and file placement.

---

## Getting Started

### Requirements

| Platform | Requirement |
|---|---|
| iOS | Xcode 16+, iOS 17+ simulator or device |
| Android | Android Studio Hedgehog+, API 26+ emulator or device |

### Clone & run

```bash
git clone https://github.com/theosementa/modulo-ios.git
cd modulo-ios
```

**iOS** — open `iosApp/Modulo.xcodeproj` in Xcode, select the `Modulo` scheme and hit **Run**.

**Android** — open the root project in Android Studio and run the `androidApp` configuration.

No additional setup required.

---

## Roadmap

Upcoming features and improvements are tracked on the [GitHub Project board](https://github.com/theosementa/modulo-ios/projects).

Feature requests and suggestions are welcome — feel free to [open an issue](https://github.com/theosementa/modulo-ios/issues/new).

---

## Contributing

Contributions are welcome! Feel free to open an issue to report a bug, suggest a feature, or discuss the architecture. Pull requests are appreciated.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes
4. Open a pull request against `develop`

---

## License

This project is licensed under the [PolyForm Noncommercial License 1.0](./LICENSE).  
Free for personal and non-commercial use. Commercial use is not permitted.

---

## Author & Contributors

| Role | Person |
|---|---|
| Architect & Developer | [**Theo Sementa**](https://x.com/theosementa) |
| App Icons Design | **Zoé Cridel** |
| AI Developer | **Claude** (Anthropic) |