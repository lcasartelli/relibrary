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
  window.getQueryStringValue = function(key) {
    var search = window.location.href.split('?')[1];
    var _r_val;
    if(search !== undefined) {
      var eachVariables = search.split('&');
      var pairs = null;
      eachVariables.forEach(function(variables) {
        pairs = variables.split('=');
        pairs.forEach(function(val, index) {
          if(index % 2 === 0 && val === key) {
            _r_val = pairs[index + 1];
          }
        });
      });
    }
    return _r_val;
  };

  window.showToast = function() {
    var queryStringValue = window.getQueryStringValue('toast');
    if(queryStringValue !== undefined) {
      var toast = document.querySelector('#' + queryStringValue);
      if(toast !== undefined) {
        toast.show();
      }
    }
  };

})(window);
