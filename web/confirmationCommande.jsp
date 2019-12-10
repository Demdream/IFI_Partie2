<%-- 
    Document   : verificationCommande
    Created on : 9 déc. 2019, 01:22:02
    Author     : PSDT0769
--%>

<div id="singleColumn">

    <p id="confirmationText">
        <strong>Votre commande est validée</strong>
    </p>

    <div class="summaryColumn" >

        <table id="commandeTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">order summary</th>
            </tr>

            <tr class="tableHeading">
                <td>nom</td>
                <td>quantité</td>
                <td>prix</td>
            </tr>

            <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${products[iter.index].name}</td>
                    <td class="quantityColumn">
                        ${orderedProduct.quantity}
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; ${products[iter.index].price * orderedProduct.quantity}
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="deliverySurchargeCellLeft"><strong>frais de livraison:</strong></td>
                <td id="deliverySurchargeCellRight">&euro; ${initParam.fraisLivraison}</td>
            </tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>total:</strong></td>
                <td id="totalCellRight">&euro; ${orderRecord.amount}</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>


        </table>

    </div>

</div>