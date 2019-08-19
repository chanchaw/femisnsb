(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["pages-page2-page2-module"],{

/***/ "./src/app/pages/page2/content/content.component.css":
/*!***********************************************************!*\
  !*** ./src/app/pages/page2/content/content.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pages/page2/content/content.component.html":
/*!************************************************************!*\
  !*** ./src/app/pages/page2/content/content.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>page2的content组件</p>\n"

/***/ }),

/***/ "./src/app/pages/page2/content/content.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/pages/page2/content/content.component.ts ***!
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
            template: __webpack_require__(/*! ./content.component.html */ "./src/app/pages/page2/content/content.component.html"),
            styles: [__webpack_require__(/*! ./content.component.css */ "./src/app/pages/page2/content/content.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ContentComponent);
    return ContentComponent;
}());



/***/ }),

/***/ "./src/app/pages/page2/page2-route.module.ts":
/*!***************************************************!*\
  !*** ./src/app/pages/page2/page2-route.module.ts ***!
  \***************************************************/
/*! exports provided: ROUTES, Page2RouteModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ROUTES", function() { return ROUTES; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page2RouteModule", function() { return Page2RouteModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _page2_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./page2.component */ "./src/app/pages/page2/page2.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var ROUTES = [
    {
        path: '',
        component: _page2_component__WEBPACK_IMPORTED_MODULE_2__["Page2Component"]
    }
];
var Page2RouteModule = /** @class */ (function () {
    function Page2RouteModule() {
    }
    Page2RouteModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(ROUTES)
            ],
            exports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
            ]
        })
    ], Page2RouteModule);
    return Page2RouteModule;
}());



/***/ }),

/***/ "./src/app/pages/page2/page2.component.css":
/*!*************************************************!*\
  !*** ./src/app/pages/page2/page2.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pages/page2/page2.component.html":
/*!**************************************************!*\
  !*** ./src/app/pages/page2/page2.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-content></app-content>"

/***/ }),

/***/ "./src/app/pages/page2/page2.component.ts":
/*!************************************************!*\
  !*** ./src/app/pages/page2/page2.component.ts ***!
  \************************************************/
/*! exports provided: Page2Component */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page2Component", function() { return Page2Component; });
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

var Page2Component = /** @class */ (function () {
    function Page2Component() {
    }
    Page2Component.prototype.ngOnInit = function () {
    };
    Page2Component = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-page2',
            template: __webpack_require__(/*! ./page2.component.html */ "./src/app/pages/page2/page2.component.html"),
            styles: [__webpack_require__(/*! ./page2.component.css */ "./src/app/pages/page2/page2.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], Page2Component);
    return Page2Component;
}());



/***/ }),

/***/ "./src/app/pages/page2/page2.module.ts":
/*!*********************************************!*\
  !*** ./src/app/pages/page2/page2.module.ts ***!
  \*********************************************/
/*! exports provided: Page2Module */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page2Module", function() { return Page2Module; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _page2_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./page2.component */ "./src/app/pages/page2/page2.component.ts");
/* harmony import */ var _content_content_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./content/content.component */ "./src/app/pages/page2/content/content.component.ts");
/* harmony import */ var _page2_page2_route_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../page2/page2-route.module */ "./src/app/pages/page2/page2-route.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var Page2Module = /** @class */ (function () {
    function Page2Module() {
    }
    Page2Module = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"], _page2_page2_route_module__WEBPACK_IMPORTED_MODULE_4__["Page2RouteModule"]
            ],
            declarations: [_page2_component__WEBPACK_IMPORTED_MODULE_2__["Page2Component"], _content_content_component__WEBPACK_IMPORTED_MODULE_3__["ContentComponent"]]
        })
    ], Page2Module);
    return Page2Module;
}());



/***/ })

}]);
//# sourceMappingURL=pages-page2-page2-module.js.map