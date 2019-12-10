<%-- 
    Document   : verificationCommande
    Created on : 9 déc. 2019, 01:22:02
    Author     : PSDT0769
--%>

<div id="singleColumn">

    <h2>Verification Commande</h2>

    <p>In order to purchase the items in your shopping cart, please provide us with the following information:</p>


        <table id="prixBox">
            <tr>
                <td>subtotal:</td>
                <td class="verificationPrixColumn">
                    &euro; ${phone.subtotal}</td>
            </tr>
            
            <tr>
                <td>delivery surcharge:</td>
                <td class="verificationPrixColumn">
                    &euro; ${initParam.fraisLivraison}</td>
            </tr>
            <tr>
                <td class="total">total:</td>
                <td class="total verificationPrixColumn">
                    &euro; ${phone.total}</td>
            </tr>
        </table>
</div>