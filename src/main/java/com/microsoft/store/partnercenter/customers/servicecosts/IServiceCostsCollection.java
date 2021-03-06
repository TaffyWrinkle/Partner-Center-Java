// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license. See the LICENSE file in the project root for full license information.

package com.microsoft.store.partnercenter.customers.servicecosts;

import com.microsoft.store.partnercenter.IPartnerComponent;
import com.microsoft.store.partnercenter.models.utils.Tuple;

/**
 * Holds the operations related to a customer's service costs.
 */
public interface IServiceCostsCollection
    extends IPartnerComponent<Tuple<String, String>>
{
    /**
     * Gets the customer's service cost line items.
     * 
     * @return The customer's service cost line items.
     */
    IServiceCostLineItemsCollection getLineItems();

    /**
     * Gets the customer's service cost summary.
     * 
     * @return The customer's service cost summary.
     */
    IServiceCostSummary getSummary();
}