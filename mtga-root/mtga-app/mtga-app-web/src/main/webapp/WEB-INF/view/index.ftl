<#import "/spring.ftl" as spring />

<html>
  <body>
    <p>Hello ${name}
    <ul>
      <li><a href="<@spring.url '/search' />">Browse</a>
    </ul>
  </body>
</html>