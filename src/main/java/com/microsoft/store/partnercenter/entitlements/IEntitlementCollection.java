// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license. See the LICENSE file in the project root for full license information.

package com.microsoft.store.partnercenter.entitlements;

import com.microsoft.store.partnercenter.IPartnerComponentString;
import com.microsoft.store.partnercenter.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.entitlements.Entitlement;

/**
 *  Represents the operations that can be performed on entitlements associated to the customer based on the logged in partner.
 */
public interface IEntitlementCollection 
	extends IPartnerComponentString, IEntireEntityCollectionRetrievalOperations<Entitlement, ResourceCollection<Entitlement>>
{
	/**
	 * Retrieves the operations that can be applied on entitlements with a given entitlement type.
	 * 
	 * @param entitlementType The type of entitlement.
	 * @return The entitlement collection operations by entitlement type.
	 */
     IEntireEntityCollectionRetrievalOperations<Entitlement, ResourceCollection<Entitlement>> byEntitlementType(String entitlementType);

    /**
     * Gets the entitlements for a customer.
     * 
     * @param showExpiry A flag to indicate if the expiry date is required to be returned along with the entitlement (if applicable).
     * @return The collection of entitlements for the customer.
     */
    ResourceCollection<Entitlement> get(Boolean showExpiry);
}