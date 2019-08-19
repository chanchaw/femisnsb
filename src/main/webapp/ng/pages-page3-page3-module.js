(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["pages-page3-page3-module"],{

/***/ "./src/app/pages/page3/content/content.component.css":
/*!***********************************************************!*\
  !*** ./src/app/pages/page3/content/content.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pages/page3/content/content.component.html":
/*!************************************************************!*\
  !*** ./src/app/pages/page3/content/content.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  page3的content组件\n</p>\n"

/***/ }),

/***/ "./src/app/pages/page3/content/content.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/pages/page3/content/content.component.ts ***!
  \**********************************************************/
/*! exports provided: ContentComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContentComponent", function() { return ContentComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ContentComponent = /** @class */ (function () {
    function ContentComponent() {
    }
    ContentComponent.prototype.ngOnInit = function () {
    };
    ContentComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-content',
            template: __webpack_require__(/*! ./content.component.html */ "./src/app/pages/page3/content/content.component.html"),
            styles: [__webpack_require__(/*! ./content.component.css */ "./src/app/pages/page3/content/content.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ContentComponent);
    return ContentComponent;
}());



/***/ }),

/***/ "./src/app/pages/page3/page3-route.module.ts":
/*!***************************************************!*\
  !*** ./src/app/pages/page3/page3-route.module.ts ***!
  \***************************************************/
/*! exports provided: ROUTES, Page3RouteModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ROUTES", function() { return ROUTES; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page3RouteModule", function() { return Page3RouteModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _page3_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./page3.component */ "./src/app/pages/page3/page3.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var ROUTES = [
    {
        path: '',
        component: _page3_component__WEBPACK_IMPORTED_MODULE_2__["Page3Component"]
    }
];
var Page3RouteModule = /** @class */ (function () {
    function Page3RouteModule() {
    }
    Page3RouteModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(ROUTES)
            ],
            exports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
            ]
        })
    ], Page3RouteModule);
    return Page3RouteModule;
}());



/***/ }),

/***/ "./src/app/pages/page3/page3.component.css":
/*!*************************************************!*\
  !*** ./src/app/pages/page3/page3.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pages/page3/page3.component.html":
/*!**************************************************!*\
  !*** ./src/app/pages/page3/page3.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-content></app-content>"

/***/ }),

/***/ "./src/app/pages/page3/page3.component.ts":
/*!************************************************!*\
  !*** ./src/app/pages/page3/page3.component.ts ***!
  \************************************************/
/*! exports provided: Page3Component */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page3Component", function() { return Page3Component; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var Page3Component = /** @class */ (function () {
    function Page3Component() {
    }
    Page3Component.prototype.ngOnInit = function () {
    };
    Page3Component = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-page3',
            template: __webpack_require__(/*! ./page3.component.html */ "./src/app/pages/page3/page3.component.html"),
            styles: [__webpack_require__(/*! ./page3.component.css */ "./src/app/pages/page3/page3.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], Page3Component);
    return Page3Component;
}());



/***/ }),

/***/ "./src/app/pages/page3/page3.module.ts":
/*!*********************************************!*\
  !*** ./src/app/pages/page3/page3.module.ts ***!
  \*********************************************/
/*! exports provided: Page3Module */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page3Module", function() { return Page3Module; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _page3_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./page3.component */ "./src/app/pages/page3/page3.component.ts");
/* harmony import */ var _content_content_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./content/content.component */ "./src/app/pages/page3/content/content.component.ts");
/* harmony import */ var _page3_page3_route_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../page3/page3-route.module */ "./src/app/pages/page3/page3-route.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var Page3Module = /** @class */ (function () {
    function Page3Module() {
    }
    Page3Module = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _page3_page3_route_module__WEBPACK_IMPORTED_MODULE_4__["Page3RouteModule"]
            ],
            declarations: [_page3_component__WEBPACK_IMPORTED_MODULE_2__["Page3Component"], _content_content_component__WEBPACK_IMPORTED_MODULE_3__["ContentComponent"]]
        })
    ], Page3Module);
    return Page3Module;
}());



/***/ })

}]);
//# sourceMappingURL=pages-page3-page3-module.js.map