
var CommonUtil = {
    isEmpty : function(_obj) {
        try {
            if(_obj == null || _obj == undefined || _obj == 'null' || _obj == 'undefined' || _obj == "") {
                return true;
            } else {
                return false;
            }
        } catch(e) {
            return true;
        }
    }
    , isEmail : function(_obj) {
        var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
        if(this.isEmpty(_obj) || !_obj.match(regExp)) {
            return false;
        }
        return true;
    }
};