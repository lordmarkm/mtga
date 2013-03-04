<html>
  <table>
  
    <#list cards as card>
      <tr>
        ${card_index + 1}. ${card.name}
        <ul>
          <li><img src="/img/${card.expansion.abbreviation}/${card.name}" />
          <li>${card.expansion.name} (${card.expansion.abbreviation})
          <li>${card.castingCost.string}
        </ul>
      </tr>
    </#list>
  
  </table>
</html>