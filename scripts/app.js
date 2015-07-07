/*
Copyright (c) 2015 The Polymer Project Authors. All rights reserved.
This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
Code distributed by Google as part of the polymer project is also
subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
*/
(function(window) {
  'use strict';
  window.deleteGlobal = function() {
    window.queryString = undefined;
  };
  window.setGloablQueryString = function(queryString) {
    window.queryString = queryString;
  };
  window.getQueryStringValue = function(key, queryString) {
    var _r_val;
    var pairs = queryString.split('=');
    pairs.forEach(function(val, index) {
      if(index % 2 === 0 && val === key) {
        _r_val = pairs[index + 1];
      }
    });
    return _r_val;
  };

  window.showToast = function(toast, ritardo) {
    if(ritardo === null) {
      ritardo = 0;
    }
    if(toast !== undefined) {
      setTimeout(function() {toast.show();}, ritardo);
    }
  };

  window.showToastFromRedirect = function(queryString) {
    var queryStringValue = window.getQueryStringValue('toast', queryString);
    if(queryStringValue !== undefined) {
      window.showToast(document.querySelector('#' + queryStringValue), 500);
    }
    if(queryString !== undefined) {
      window.setGloablQueryString(queryString);
    }
  };

})(window);
