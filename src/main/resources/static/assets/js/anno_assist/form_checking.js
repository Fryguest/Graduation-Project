/**
 * Created by gwli on 17-10-18.
 */

function checkFileInput(file_input) {
    if ("" == file_input.value) {
        return false;
    }
    return true;
}

function checkTextareaTaskIdMulti(text_area) {
    var re = new RegExp("[^0-9,，]+");
    var val = text_area.value;
    if ("" == val || re.test(val)) {
        return false;
    }
    return true;
}

function checkInputOnlyInteger(input) {
    var re = new RegExp("[^0-9]+");
    var val = input.value;
    if ("" == val || re.test(val)) {
        return false;
    }
    if (parseInt(val) > ((1 << 30) * 2 - 1)) {
        return false;
    }
    return true;
}

function checkForm() {
    var text_areas = document.querySelectorAll(".multi_task_input");
    if (text_areas.length > 0) {
        for (var i = 0; i < text_areas.length; ++i) {
            if (!checkTextareaTaskIdMulti(text_areas[i])) {
                alert("输入数据格式错误，请检查！");
                return false;
            }
        }
    }
    var inputs = document.querySelectorAll(".only_one_integer_input");
    if (inputs.length > 0) {
        for (var i = 0; i < inputs.length; ++i) {
            if (!checkInputOnlyInteger(inputs[i])) {
                alert("输入数据格式错误，请检查！");
                return false;
            }
        }
    }
    var file_inputs = document.querySelectorAll(".file_path_input");
    if (file_inputs.length > 0) {
        for (var i = 0; i < file_inputs.length; ++i) {
            if (!checkFileInput(file_inputs[i])) {
                alert("没有输入文件，请检查！");
                return false;
            }
        }
    }
    return true;
}