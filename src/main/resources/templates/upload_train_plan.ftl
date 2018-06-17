<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>高校教务管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- basic styles -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="assets/css/dropzone.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<#include "header.ftl">
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

  <#include "left.ftl">

        <div class="main-content">
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        上传培养计划
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- CONTENT BEGINS -->
                        <form class="form-horizontal" role="form" action="/uploadTrainPlan" method="post">
                            <div class="form-group">
                            <#--<input name="tasktype" type="hidden" value="${taskType}"/>-->

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly">
                                        任务类型 </label>
                                    <div class="col-sm-9">
                                        <input readonly="" type="text" class="col-xs-10 col-sm-5"
                                               id="form-input-readonly" value="上传培养计划"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"> 培养计划 </label>
                                    <div class="col-sm-6">
                                        <input id="student_list" name="train_plan" type="hidden"/>
                                        <div class="dropzone" data-val="train_plan">
                                            <div class="fallback">
                                                <input name="train_plan" type="file"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="space-4"></div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"> 选择专业 </label>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" id="form-field-8" name="major"
                                                  rows="1"></textarea>
                                    </div>
                                </div>


                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-3 col-md-9">
                                    <button class="btn btn-info" type="submit">
                                        <i class="icon-ok bigger-110"></i>
                                        上传
                                    </button>
                                    &nbsp; &nbsp; &nbsp;
                                    <button class="btn" type="reset">
                                        <i class="icon-undo bigger-110"></i>
                                        重置
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->

            </div><!-- /.page-content -->
        </div><!-- /.main-content -->

    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) {
        document.write(
                "<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
    }
</script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="assets/js/dropzone.min.js"></script>

<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function ($) {
        try {
            $(".dropzone").dropzone({
                url: "/upload",
                paramName: "file", // The name that will be used to transfer the file
                maxFilesize: 50, // MB
                headers: {"uploadid": "${taskType}"},
                maxFiles: 1,
                addRemoveLinks: true,
                dictDefaultMessage: '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
					<span class="smaller-80 grey">(or click)</span> <br /> \
					<i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
                dictResponseError: 'Error while uploading file!',

                //change the previewTemplate to use Bootstrap progress bars
                previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
                init: function () {
                    var key = this.element.dataset.val;
                    this.on("success", function (file, data) {
                        console.log(key + " : " + data.filename);
                        $("#" + key).val(data.filename);
                    });
                }
            });
        } catch (e) {
            alert('Dropzone.js does not support older browsers!');
        }

    });
</script>
</body>
</html>