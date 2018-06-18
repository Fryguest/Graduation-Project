<div class="sidebar" id="sidebar">
  <script type="text/javascript">
    try {
      ace.settings.check('sidebar', 'fixed')
    } catch (e) {
    }
  </script>

  <ul class="nav nav-list">
    <li>
      <a href="/index">
        <i class="icon-th-large"></i>
        <span class="menu-text"> 首页 </span>
      </a>
    </li>
    <li <#if taskType??  && (taskType >= 10000 && taskType < 20000)>class="active open"</#if>>
      <a href="#" class="dropdown-toggle">
        <i class="icon-arrow-down"></i>
        <span class="menu-text"> 学生入口 </span>
        <b class="arrow icon-angle-down"></b>
      </a>
      <ul class="submenu">
        <li <#if taskType?? && taskType == 10000>class="active"</#if>>
          <a href="studentcourseChosenFront">
            <i class="icon-double-angle-right"></i>
            选课入口
          </a>
        </li>
        <li <#if taskType?? && taskType == 10003>class="active"</#if>>
          <a href="studentdownloadCourseChosenTableFront">
            <i class="icon-double-angle-right"></i>
            下载选课表
          </a>
        </li>
        <li <#if taskType?? && taskType == 10001>class="active"</#if>>
          <a href="studentcheckGPAFront">
            <i class="icon-double-angle-right"></i>
            查看培养计划及成绩
          </a>
        </li>
        <li <#if taskType?? && taskType == 10002>class="active"</#if>>
          <a href="studentdownloadStudentTimetableFront">
            <i class="icon-double-angle-right"></i>
            查看课表
          </a>
        </li>
        <li <#if taskType?? && taskType == 10004>class="active"</#if>>
          <a href="studentExamRegistrationFront">
            <i class="icon-double-angle-right"></i>
            考试报名
          </a>
        </li>
      </ul>
    </li>
    <li <#if taskType??  && (taskType >= 20000 && taskType < 30000)>class="active open"</#if>>
      <a href="#" class="dropdown-toggle">
        <i class="icon-arrow-down"></i>
        <span class="menu-text"> 教师入口 </span>
        <b class="arrow icon-angle-down"></b>
      </a>
      <ul class="submenu">
        <li <#if taskType?? && taskType == 20000>class="active"</#if>>
          <a href="teacherdownloadCourseStudentFront">
            <i class="icon-double-angle-right"></i>
            下载学生名单
          </a>
        </li>
        <li <#if taskType?? && taskType == 20001>class="active"</#if>>
          <a href="teacheruploadCourseScoreFront">
            <i class="icon-double-angle-right"></i>
            上传考试成绩
          </a>
        </li>
        <li <#if taskType?? && taskType == 20002>class="active"</#if>>
          <a href="teacherdownloadTeacherTimetableFront">
            <i class="icon-double-angle-right"></i>
            查看课表
          </a>
        </li>
      </ul>
    </li>
    <li <#if taskType??  && (taskType >= 30000 && taskType < 40000)>class="active open"</#if>>
      <a href="#" class="dropdown-toggle">
        <i class="icon-arrow-down"></i>
        <span class="menu-text"> manager入口 </span>
        <b class="arrow icon-angle-down"></b>
      </a>
      <ul class="submenu">
        <li <#if taskType?? && taskType == 30000>class="active"</#if>>
          <a href="managerimportStudentFront">
            <i class="icon-double-angle-right"></i>
            新生名单导入
          </a>
        </li>
        <li <#if taskType?? && taskType == 30006>class="active"</#if>>
          <a href="managerimportTeacherFront">
            <i class="icon-double-angle-right"></i>
            教师名单导入
          </a>
        </li>
        <li <#if taskType?? && taskType == 30001>class="active"</#if>>
          <a href="manageruploadTrainPlanFront">
            <i class="icon-double-angle-right"></i>
            上传培养计划
          </a>
        </li>
        <li <#if taskType?? && taskType == 30009>class="active"</#if>>
          <a href="managerdownloadTrainPlanFront">
            <i class="icon-double-angle-right"></i>
            下载培养计划
          </a>
        </li>
        <li <#if taskType?? && taskType == 30007>class="active"</#if>>
          <a href="manageruploadCourseInformationFront">
            <i class="icon-double-angle-right"></i>
            上传开课信息
          </a>
        </li>
        <li <#if taskType?? && taskType == 30002>class="active"</#if>>
          <a href="/managerdownloadStudentFront">
            <i class="icon-double-angle-right"></i>
            下载学生名单
          </a>
        </li>
        <li <#if taskType?? && taskType == 30008>class="active"</#if>>
          <a href="/managerdownloadTeacherFront">
            <i class="icon-double-angle-right"></i>
            下载教师名单
          </a>
        </li>
        <li <#if taskType?? && taskType == 30003>class="active"</#if>>
          <a href="/managerdownloadClassFront">
            <i class="icon-double-angle-right"></i>
            下载班级名单
          </a>
        </li>
        <li <#if taskType?? && taskType == 30004>class="active"</#if>>
          <a href="/managerprofessionalDiversionFront">
            <i class="icon-double-angle-right"></i>
            专业分流
          </a>
        </li>
        <li <#if taskType?? && taskType == 30005>class="active"</#if>>
          <a href="/managerdistributionTeacherFront">
            <i class="icon-double-angle-right"></i>
            分配班主任
          </a>
        </li>
      </ul>
    </li>
    <li>
      <a href="#" class="dropdown-toggle">
        <i class="icon-arrow-down"></i>
        <span class="menu-text"> 敬请期待 </span>
        <b class="arrow icon-angle-down"></b>
      </a>
    </li>
  </ul><!-- /.nav-list -->

  <div class="sidebar-collapse" id="sidebar-collapse">
    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
  </div>

  <script type="text/javascript">
    try {
      ace.settings.check('sidebar', 'collapsed')
    } catch (e) {
    }
  </script>
</div>