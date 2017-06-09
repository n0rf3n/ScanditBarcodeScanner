//startup.js file
var globalhttpheaders = {};
var appConfig = {
    appId: "BarcodeScannerEx",
    appName: "BarcodeScannerEx",
    appVersion: "1.0.0",
    platformVersion: null,
    serverIp: "192.168.1.102",
    serverPort: "80",
    secureServerPort: "443",
    isDebug: true,
    middlewareContext: "BarcodeScannerEx",
    isMFApp: false,
    eventTypes: ["FormEntry", "ServiceRequest", "Error", "Crash"],
    url: "https://karthi2.konycloud.com/BarcodeScannerEx/MWServlet",
    secureurl: "https://karthi2.konycloud.com/BarcodeScannerEx/MWServlet"
};
sessionID = "";

function appInit(params) {
    skinsInit();
    frmStartupGlobals();
    setAppBehaviors();
};

function setAppBehaviors() {
    kony.application.setApplicationBehaviors({
        applyMarginPaddingInBCGMode: false,
        adherePercentageStrictly: true,
        retainSpaceOnHide: true,
        marginsIncludedInWidgetContainerWeight: true,
        APILevel: 7200
    })
};

function themeCallBack() {
    callAppMenu();
    initializeGlobalVariables();
    kony.application.setApplicationInitializationEvents({
        init: appInit,
        showstartupform: function() {
            frmStartup.show();
        }
    });
};

function loadResources() {
    globalhttpheaders = {};
    kony.os.loadLibrary({
        "javaclassname": "com.konylabs.ffi.N_BarcodeScannerNamespace"
    });
    sdkInitConfig = {
        "appConfig": appConfig,
        "isMFApp": appConfig.isMFApp,
        "eventTypes": appConfig.eventTypes,
    }
    kony.theme.setCurrentTheme("default", themeCallBack, themeCallBack);
};

function onSuccessSDKCallBack() {
    kony.theme.setCurrentTheme("default", themeCallBack, themeCallBack);
}
kony.application.setApplicationMode(constants.APPLICATION_MODE_NATIVE);
//If default locale is specified. This is set even before any other app life cycle event is called.
loadResources();
// If you wish to debug Application Initialization events, now is the time to
// place breakpoints.
debugger;