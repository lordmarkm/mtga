<html>
  <table>
  
    <#list cards as card>
      <tr>
        ${card_index + 1}. ${card.name}
        <ul>
          <li>${card.expansion.name} (${card.expansion.abbreviation})
          <li>${card.castingCost.string}
        </ul>
      </tr>
    </#list>
  
  </table>
</html>