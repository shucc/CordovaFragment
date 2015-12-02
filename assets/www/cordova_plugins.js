cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/cordova-plugin-whitelist/whitelist.js",
        "id": "cordova-plugin-whitelist.whitelist",
        "runs": true
    },
    {
        "file":"plugin/bridgePlugin.js",
        "id":"org.cchao.cordovafragment.bridgePlugin",
        "clobbers": [
            "navigator.bridgePlugin"
        ]
    }
];
module.exports.metadata = 
{
    "cordova-plugin-whitelist": "1.2.0",
    "org.cchao.cordovafragment.bridgePlugin":"1.0.0",
}
});