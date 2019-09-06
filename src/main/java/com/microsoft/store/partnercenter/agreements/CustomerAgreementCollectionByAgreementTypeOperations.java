// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license. See the LICENSE file in the project root for full license information.

package com.microsoft.store.partnercenter.agreements;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponent;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.agreements.Agreement;
import com.microsoft.store.partnercenter.models.utils.KeyValuePair;
import com.microsoft.store.partnercenter.models.utils.Tuple;

import com.microsoft.store.partnercenter.models.agreements.AgreementType;
import com.microsoft.store.partnercenter.models.utils.KeyValuePair;
import com.microsoft.store.partnercenter.models.utils.Tuple;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Customer agreements operations by agreement type implementation class.
 */
public class CustomerAgreementCollectionByAgreementTypeOperations
        extends BasePartnerComponent<Tuple<String, String>>
        implements ICustomerAgreementCollectionByAgreementType
{
    /**
     * Initializes a new instance of the CustomerAgreementCollectionByAgreementTypeOperations class.
     *
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer identifier.
     * @param agreementType The type of agreement.
     */
    public CustomerAgreementCollectionByAgreementTypeOperations(IPartner rootPartnerOperations, String customerId, String agreementType)
    {
        super(rootPartnerOperations, new Tuple<String, String>(customerId, agreementType));

        if (agreementType == null)
        {
            throw new IllegalArgumentException("agreementType must be set");
        }
    }

    /**
     * Gets the list of agreements between a partner and customer for specified agreement type.
     *
     * @return The list of the customer's agreements for specified agreement type.
     */
    @Override
    public ResourceCollection<Agreement> get()
    {
        Collection<KeyValuePair<String, String>> parameters = new ArrayList<KeyValuePair<String, String>>();

        parameters.add
        (
            new KeyValuePair<String, String>
            (
                    PartnerService.getInstance().getConfiguration().getApis().get("GetAgreementsDetails").getParameters().get("AgreementType"),
                    this.getContext().getItem2()
            )
        );

        return this.getPartner().getServiceClient().get(
                this.getPartner(),
                new TypeReference<ResourceCollection<Agreement>>(){},
                MessageFormat.format(
                        PartnerService.getInstance().getConfiguration().getApis().get("GetCustomerAgreements").getPath(),
                        this.getContext().getItem1()),
                parameters);
    }
}