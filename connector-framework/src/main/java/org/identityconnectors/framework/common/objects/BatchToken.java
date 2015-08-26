/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015 ForgeRock AS. All rights reserved.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 */
package org.identityconnectors.framework.common.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates zero or more tokens resulting from submission of a set of batched operations to an external resource
 * via a connector.
 *
 * tokens is a List of Strings representing the tokens used by the resource (or generated by the connector if the
 * resource does not use tokens).  These tokens are opaque to the application.
 *
 * If a follow-up queryBatch() call is required to fetch the results of an executeBatch() or additional results
 * following another queryBatch() then this BatchToken should contain queryRequired == true.  If false then the
 * application need not issue another queryBatch() command; All results are returned with the command that returned
 * this BatchToken.
 *
 * If results will be returned asynchronous to the return of this BatchToken then asynchronousResults should be
 * true.  If false then the expectation is that this BatchToken represents the final data returned by the connector.
 */
public class BatchToken {
    private final List<String> tokens = new ArrayList<String>();
    private boolean queryRequired = false;
    private boolean asynchronousResults = false;

    public BatchToken() {}

    public BatchToken(String token) {
        tokens.add(token);
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    public void removeToken(String token) {
        tokens.remove(token);
    }

    public List<String> getTokens() {
        return new ArrayList<String>(tokens);
    }

    public boolean hasToken(String token) {
        return tokens.contains(token);
    }

    public boolean isQueryRequired() {
        return queryRequired;
    }

    public void setQueryRequired(boolean queryRequired) {
        this.queryRequired = queryRequired;
    }

    public boolean hasAsynchronousResults() {
        return asynchronousResults;
    }

    public void setAsynchronousResults(boolean asynchronousResults) {
        this.asynchronousResults = asynchronousResults;
    }
}
