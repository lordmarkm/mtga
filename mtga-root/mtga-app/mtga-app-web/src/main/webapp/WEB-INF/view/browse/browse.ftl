<#import "/spring.ftl" as spring />

<html>
  <table>
  
    <#list cards as card>
      <tr>
        ${card_index + 1}. ${card.name}
        <ul>
          
          <#if card.expansion??>
          <li><img src="<@spring.url '/img/${card.expansion.abbreviation}/${card.name}' />" />
          <li>${card.expansion.name} (${card.expansion.abbreviation})
          <#else>
          <li>No expansion specified
          </#if>
          
          <#if card.castingCost??>
          <li>${card.castingCost.string}
          <#else>
          <li>No casting cost specified
          </#if>
          
        </ul>
      </tr>
    </#list>
  
  </table>
</html>