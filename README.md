# Flutter_Faust Example Template

Template for Flutter & Faust DSP Project.

You can use [Change Package Name](https://pub.dev/packages/change_app_package_name) Package to change its name.

Added Android Support upon [Github@Oshibka404's faust_flutter](https://github.com/oshibka404/faust_flutter).

## How to Build

[Detailed Explanation written in Korean](https://potatosalad775.tistory.com/7)

### Install Faust Package

faust2api script only works on bash, you can use WSL on Windows.

```
$ sudo apt-get update
$ sudo apt-get install faust
```

### Build DSP Layer with faust2api

```
$ faust2api -android -nozip /DIR_TO_DSP_FILE
or
$ faust2api -ios -nozip -target /DIR_TO_DSP_FILE
```

### Run Flutter

```
$ flutter run
```
