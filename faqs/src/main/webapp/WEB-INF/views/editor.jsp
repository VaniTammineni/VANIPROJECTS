<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<script src= "<%=request.getContextPath() %>/resources/js/shaalgorithm.js"> </script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/roboto-font.css"> --%>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/daterangepicker.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/select2.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" media="all">
<link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/alexkrolick/pen/xgyOXQ?depth=everything&order=popularity&page=6&q=react&show_forks=false" />

<link rel='stylesheet prefetch' href='https://unpkg.com/react-quill@1.0.0/dist/quill.core.css'><link rel='stylesheet prefetch' href='https://unpkg.com/react-quill@1.0.0/dist/quill.snow.css'><link rel='stylesheet prefetch' href='https://unpkg.com/react-quill@1.0.0/dist/quill.bubble.css'>
<style class="cp-pen-styles">body {
  background: #f3f1f2;
  font-family: sans-serif;
}

.app {
  margin: 1rem 4rem;
}

.app .ql-container {
  border-bottom-left-radius: 0.5em;
  border-bottom-right-radius: 0.5em;
  background: #fefcfc;
}

/* Snow Theme */
.app .ql-snow.ql-toolbar {
  display: block;
  background: #eaecec;
  border-top-left-radius: 0.5em;
  border-top-right-radius: 0.5em;
}

/* Bubble Theme */
.app .ql-bubble .ql-editor {
  border: 1px solid #ccc;
  border-radius: 0.5em;
}

.app .ql-editor {
  min-height: 18em;
}

.themeSwitcher {
  margin-top: 0.5em;
  font-size: small;
}</style>

<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/react/15.6.1/react.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/react/15.6.1/react-dom.js'></script><script src='https://unpkg.com/prop-types/prop-types.js'></script><script src='https://unpkg.com/react-quill@latest/dist/react-quill.js'></script>
<script >'use strict';

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

/* 
 * Simple editor component that takes placeholder text as a prop 
 */

var Editor = function (_React$Component) {
  _inherits(Editor, _React$Component);

  function Editor(props) {
    _classCallCheck(this, Editor);

    var _this = _possibleConstructorReturn(this, _React$Component.call(this, props));

    _this.state = { editorHtml: '', theme: 'snow' };
    _this.handleChange = _this.handleChange.bind(_this);
    return _this;
  }

  Editor.prototype.handleChange = function handleChange(html) {
    this.setState({ editorHtml: html });
  };

  Editor.prototype.handleThemeChange = function handleThemeChange(newTheme) {
    if (newTheme === "core") newTheme = null;
    this.setState({ theme: newTheme });
  };

  Editor.prototype.render = function render() {
    var _this2 = this;

    return React.createElement(
      'div',
      null,
      React.createElement(ReactQuill, {
        theme: this.state.theme,
        onChange: this.handleChange,
        value: this.state.editorHtml,
        modules: Editor.modules,
        formats: Editor.formats,
        bounds: '.app',
        placeholder: this.props.placeholder
      }),
      React.createElement(
        'div',
        { className: 'themeSwitcher' },
        React.createElement(
          'label',
          null,
          'Theme '
        ),
        React.createElement(
          'select',
          { onChange: function onChange(e) {
              return _this2.handleThemeChange(e.target.value);
            } },
          React.createElement(
            'option',
            { value: 'snow' },
            'Snow'
          ),
          React.createElement(
            'option',
            { value: 'bubble' },
            'Bubble'
          ),
          React.createElement(
            'option',
            { value: 'core' },
            'Core'
          )
        )
      )
    );
  };

  return Editor;
}(React.Component);

/* 
 * Quill modules to attach to editor
 * See https://quilljs.com/docs/modules/ for complete options
 */

Editor.modules = {
  toolbar: [[{ 'header': '1' }, { 'header': '2' }, { 'font': [] }], [{ size: [] }], ['bold', 'italic', 'underline', 'strike', 'blockquote'], [{ 'list': 'ordered' }, { 'list': 'bullet' }, { 'indent': '-1' }, { 'indent': '+1' }], ['link', 'image', 'video'], ['clean']],
  clipboard: {
    // toggle to add extra line breaks when pasting HTML:
    matchVisual: false
  }
};
/* 
 * Quill editor formats
 * See https://quilljs.com/docs/formats/
 */
Editor.formats = ['header', 'font', 'size', 'bold', 'italic', 'underline', 'strike', 'blockquote', 'list', 'bullet', 'indent', 'link', 'image', 'video'];

/* 
 * PropType validation
 */
Editor.propTypes = {
  placeholder: React.PropTypes.string
};

/* 
 * Render component on page
 */
ReactDOM.render(React.createElement(Editor, { placeholder: 'Write something...' }), document.querySelector('.app'));
//# sourceURL=pen.js
</script>
</head>
<body>
<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
<form >

           
<div class="app">

</div>
</div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="Save"></label>
  <div class="col-md-4">
    <button id="Save" name="Save" class="btn btn-primary">Save</button>
  </div>
</div>


</form>
</div>

<!--                     </div> -->
<!--                     </div> -->
<!--                     </div> -->

</body></html>

