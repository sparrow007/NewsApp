# lpcpayment android sdk



## Development ENV

- android studio 3.5.3 ()
- java 8

## Configration

- you can update *BASE_URL* and *JWT_TOKEN* in *./lpcpayment/build.gradle* line18,20 in build phase

## Local Build

make sure download android sdk, and set the path for ENV value `$ANDROID_HOME`

```
➜  lpcpayment-android git:(master) ✗ echo $ANDROID_HOME
/Volumes/Data/dev-tools/Android/SDK
```

there are two methods can build the sdk aar

- under terminal, goto *lpcpayment-android*, then run `./gradlew build`, after this, you can find the aar file in *./lpcpayment/build/outputs/aar/lpcpayment-release.aar*

- open android studio, install lombok plugin for android studio ![Lombok](./i/Lombok.png)

  restart android studio, open *lpcpayment-android* project, click build->make project also can generate aar file

## Gitlab CI

- create repo in gitlab, then just push this project into remote repo

- open repo page, click CI/CD->jobs, you can see the running jobs

  ![download-aar](./i/download-aar.png)

  After three job finished, build->test->package, you can click download icon to download the distribution *.arr file 

## Verfication

- unit test, run `./gradlew clean jacocoTestReport`, then open *./lpcpayment/build/jacoco-coverage-html/index.html* to see code coverage report
  - you also can check the unit test report *./lpcpayment/build/reports/tests/testDebugUnitTest/index.html*
- run sample
  - follow *lpcpayment-mock-server/readme.md*  to startup mock server first
  - update baseUrl or jwtToken in file *./samples/src/main/java/com/poisedon/lpc/payment/samples/MainActivity.java* if need
  - run samples android App, click button to test api method, and goto mock server to check params (for test, all mock server endpoints are delay 3s)
