"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var OptionsBuilder = (function () {
    function OptionsBuilder() {
        this.appendingHeaders = [];
    }
    OptionsBuilder.prototype.appendHeader = function (key, value) {
        if (value)
            this.appendingHeaders.push({ key: key, value: value });
    };
    Object.defineProperty(OptionsBuilder.prototype, "headers", {
        get: function () {
            var ret = new Headers();
            this.appendingHeaders.forEach(function (h) { return ret.append(h.key, h.value); });
            return ret;
        },
        enumerable: true,
        configurable: true
    });
    OptionsBuilder.prototype.get = function () {
        if (this.appendingHeaders.length == 0)
            return undefined;
        return { headers: this.headers };
    };
    return OptionsBuilder;
}());
var HttpService = (function () {
    function HttpService(http) {
        this.http = http;
    }
    HttpService.prototype.prefix = function () {
        return window.urlPrefix;
    };
    Object.defineProperty(HttpService.prototype, "token", {
        get: function () {
            return sessionStorage.getItem("token");
        },
        set: function (value) {
            if (value)
                sessionStorage.setItem("token", value);
            else
                sessionStorage.removeItem("token");
        },
        enumerable: true,
        configurable: true
    });
    HttpService.prototype.url = function (urlSuffix) {
        return this.prefix() + urlSuffix;
    };
    HttpService.prototype.get = function (urlSuffix, keyValue) {
        var post = '';
        if (keyValue) {
            var data = new URLSearchParams();
            var appended = false;
            for (var key in keyValue) {
                var value = keyValue[key];
                if (value) {
                    data.append(key, value);
                    appended = true;
                }
            }
            if (appended)
                post = '?' + data.toString();
        }
        return this.http.get(this.url(urlSuffix) + post, this.newOptionsBuilder().get());
    };
    HttpService.prototype.newOptionsBuilder = function () {
        var ob = new OptionsBuilder();
        if (this.token)
            ob.appendHeader('Token', this.token);
        return ob;
    };
    return HttpService;
}());
HttpService = __decorate([
    core_1.Injectable()
], HttpService);
exports.HttpService = HttpService;
