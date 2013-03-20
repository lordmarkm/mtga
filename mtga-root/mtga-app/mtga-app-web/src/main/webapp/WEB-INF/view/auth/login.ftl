<#import "/spring.ftl" as spring />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<html>

<head>
  <title>Connect &mdash; Dumaguete</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>

<body>
  <@sec.authorize ifNotGranted="ROLE_USER">
    <table id="table">
      <tr>
        <td class="signin-option signin-facebook">Facebook</td>
        <td class="signin-option signin-twitter">Twitter</td>
        <td class="signin-option signin-none">Nevermind</td>
      </tr>
    </table>
    <p>Please connect with a third-party authentication provider</p>
    
    <form class="login" id="signin-facebook" action="<@spring.url '/signin/facebook' />" method="POST">
    </form>
  </@sec.authorize>
</body>

</html>

<style>
body {
  text-align: center;
}

#table {
  margin: auto;
  text-align: center;
  margin-top: 10%;
}

#table td {
  min-width: 100px;
  font-family: Helvetica, Arial;
  font-weight: bold;
}

.signin-option {
  cursor: pointer;
}

img.signin-option {
  width: 50px;
  height: 50px;
}

</style>

<script>
$(function(){
  $('.signin-facebook').click(function(){
    $('#signin-facebook').submit();
  });
  
  $('.signin-twitter').click(function(){
    $('#signin-twitter').submit();
  });
  
  $('.signin-none').click(function(){
    window.location.href = '<c:url value="/" />';
  });
});
</script>