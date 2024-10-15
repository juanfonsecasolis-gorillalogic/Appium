# Appium

2024 Juan M. Fonseca-Solís @ GorillaLogic.

## Description
Solution to exercises of Omprakash Chavan's course https://gorillalogic.udemy.com/course/the-complete-appium-course-for-ios-and-android.

## Requirements
* [Node.Js](https://nodejs.org/en) (required by Appium).
* Appium Server: `sudo npm install -g appium@next` (g stands for global).
* XCUITest driver: `sudo appium driver install xcuitest`.

## Simulator
* macOS 14.2 os later.
* [XCode 15.2](https://developer.apple.com/downloads/?name=Xcode).
* iOS 17.2 (install from XCode > Settings > Components).
* iOS udid: `xcrun simctl list | grep Booted`.

## Run
```
appium;
sudo appium driver install xcuitest;
```

## Appium Inspector
* [Appium Inspector](https://github.com/appium/appium-inspector) (for inspecting the layout and build the locators).
* Connection string:
```
{
  "platformName": "iOS",
  "appium:automationName": "XCUITest",
  "appium:deviceName": "iPhone 15",
  "appium:udid": "3B5EB227-9C4D-4EA8-8621-37544D56C1C9",
  "appium:app": "/Users/juan.fonseca/Repositories/Appium/demo/src/test/resources/UIKitCatalog-iphonesimulator.app",
  "appium:showXcodeLog": "true"
}
```

## Sample app for practicing automation
* [UIKitCatalog](https://github.com/appium/ios-uicatalog) 
    * Download the ZIP with the code. 
    * Run `cd UIKitCatalog; npm install`.
    * The app will be in the build/Release-iphonesimulator folder.

![](./img/UIKitCatalog.png)

## Theory [1]
* Appium is a NodeJS HTTP server that uses a client-server architecture.
* The Appium client component translates the language-specific API call to the format used by the W3C WebDriver protocol, and then to the specific driver language.

### Types of apps
| Type | Technology | Development | Performance | UX | Automation |
|---|---|---|---|---|---|
| Native | Native language | Longer | Fast | Good | Easy |
| Hybrid | Native app that renders HTML/CSS/JS | Shorter | Slow | Poor | Hard (it is tricky to access embedded content) |
| Mobile Web | Full HTML/CSS/JS | Shorter | Slow (download time) | Poor | Easy |  

## References
1. Omprakash Chavan. Appium Mobile Automation - Android & iOS + Frameworks + CICD. URL: https://gorillalogic.udemy.com/course/the-complete-appium-course-for-ios-and-android (last consulted on Oct 15th 2024).