<%-- 
    Document   : afficheProduit
    Created on : 9 déc. 2019, 01:13:54
    Author     : PSDT0769
--%>

<div id="singleColumn">

    <c:choose>
        <c:when test="${phone.numberOfItems > 1}">
            <p>Votre panier contient ${phone.numberOfItems} items.</p>
        </c:when>
        <c:when test="${phone.numberOfItems == 1}">
            <p>Votre panier contient ${phone.numberOfItems} item.</p>
        </c:when>
        <c:otherwise>
            <p>Votre panier est vide.</p>
        </c:otherwise>
    </c:choose>

    <div id="actionBar">
        <%-- clear phone widget --%>
        <c:if test="${!empty phone && phone.numberOfItems != 0}">
            <a href="voirTelephone?clear=true" class="bubble hMargin">clear phone</a>
        </c:if>

        <%-- continue shopping widget --%>
        <c:set var="value">
            <c:choose>
                <%-- if 'selectedMobilephones session object exists, send user to previously viewed mobilephones--%>
                <c:when test="${!empty selectedMobilephones}">
                    mobilephone
                </c:when>
                <%-- otherwise send user to afficheProduit.jsp--%>
                <c:otherwise>
                    afficheProduit.jsp
                </c:otherwise>
            </c:choose>
        </c:set>

        <a href="${value}" class="bubble hMargin">continuer votre shopping</a>

        <%-- verification widget --%>
        <c:if test="${!empty phone && phone.numberOfItems != 0}">
            <a href="<c:url value='verification'/>" class="bubble hMargin">proceed to verification &#x279f;</a>
        </c:if>
    </div>

    <c:if test="${!empty phone && phone.numberOfItems != 0}">

      <h4 id="subtotal">subtotal: &euro; ${phone.subtotal}</h4>

      <table id="afficheProduitTable">

        <tr class="header">
            <th>mobilephones</th>
            <th>nom</th>
            <th>prix</th>
            <th>quantity</th>
        </tr>

        <c:forEach var="phoneItem" items="${phone.items}" varStatus="iter">

          <c:set var="mobilephones" value="${phoneItem.mobilephones}"/>

          <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
            <td>
              <img src="${initParam.mobilephonesPhotoPath}${mobilephones.nom}.jpg"
                   alt="${mobilephones.nom}">
            </td>

            <td>${mobilephones.nom}</td>

            <td>
                &euro; ${phoneItem.total}
                <br>
                <span class="smallText">( &euro; ${mobilephones.prix} / unit )</span>
            </td>

            <td>
                <form action="<c:url value='ajoutPanier'/>" method="post">
                    <input type="hidden"
                           name="mobilephoneId"
                           value="${mobilephone.id}">
                    <input type="text"
                           maxlength="2"
                           size="2"
                           value="${phoneItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           name="submit"
                           value="ajout">
                </form>
            </td>
          </tr>

        </c:forEach>

      </table>

    </c:if>
</div>