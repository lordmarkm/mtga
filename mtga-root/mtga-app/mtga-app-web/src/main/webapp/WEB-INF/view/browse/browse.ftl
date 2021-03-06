<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  
  <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
  <link href="<@spring.url '/css/application.css' />" rel="stylesheet" />
  
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
  <script src="<@spring.url '/javascript/browse/browse.js' />" ></script>
</head>

<body>
  <div class="container-fluid">
  
    <div class="row-fluid">
    
      <div class="span3">
        <form class="well" action="javascript:;">
          <label>Filter</label>
          <input id="filter" type="text" placeholder="Enter filter text" />
          
          <div class="clearfix"></div>
          <button class="btn">Filter</button>
        </form>
      </div>
  
      <div class="span6 well">
        <table>
        
          <tr>
            <th>Name</th>
            <th>Cost</th>
            <th>Expansion</th>
          </tr>
        
          <#list cards.content as card>
            <tr>
              <td>${card.name}</td>
              <td>
                <#if card.castingCost??>
                  ${card.castingCost.string}
                </#if>
              </td>
              <td>
                <#if card.expansion??>
                  <#if card.expansion.logo??>
                    <img src="<@spring.url '/logo/${card.expansion.abbreviation}' />" />
                  <#else>
                    ${card.expansion.abbreviation}
                  </#if>
                </#if>
              </td>
              
              <td>
                <a class="btn" title="<@spring.message 'browse.find-in-binders' />"><i class="icon-search"></i></a>
                <a href="#addToBinderModal" class="btn" title="<@spring.message 'browse.add-to-binder' />" role="button" data-toggle="modal" ><i class="icon-book"></i></a>
              </td>
            </tr>
          </#list>
        
        </table>
      </div>
    </div>
  
  </div>
 
 <!-- Modal for user to search for this card in available binders -->
 <#include "../modals/searchinbinders.ftl">
               
 <!-- Modal for user to add this card to his binder -->
 <#include "../modals/addtobinder.ftl"> 
  
 </body>
</html>