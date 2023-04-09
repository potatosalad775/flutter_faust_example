# Flutter_Faust Example Template

Template for Flutter & Faust DSP Project.

You can use [Change Package Name](https://pub.dev/packages/change_app_package_name) Package to change its name.

Added Android Support to Github@Oshibka404's faust_flutter.

## How to Build

[Detailed Explanation written in Korean](https://potatosalad775.tistory.com/7)

1. Install Faust Package on your System.

faust2api script only works on bash, you might install WSL first.

```
$ sudo apt-get update
$ sudo apt-get install faust
```

2. Build DSP Layer with faust2api

```
$ faust2api -android -nozip /DIR_TO_DSP_FILE
or
$ faust2api -ios -nozip -target /DIR_TO_DSP_FILE
```

3. Run Flutter