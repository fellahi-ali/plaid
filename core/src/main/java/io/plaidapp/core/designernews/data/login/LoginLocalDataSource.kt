/*
 * Copyright 2018 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.plaidapp.core.designernews.data.login

import io.plaidapp.core.designernews.data.database.LoggedInUserDao
import io.plaidapp.core.designernews.data.login.model.LoggedInUser

/**
 * Local storage for Designer News login related data, implemented using SharedPreferences
 */
class LoginLocalDataSource(private val loggedInUserDao: LoggedInUserDao) {

    /**
     * Get the logged in user. If missing, null is returned
     */
    suspend fun getUser() = loggedInUserDao.getLoggedInUser()

    suspend fun setUser(loggedInUser: LoggedInUser) {
        loggedInUserDao.setLoggedInUser(loggedInUser)
    }

    /**
     * Clear all data related to this Designer News instance: user data and access token
     */
    suspend fun logout() {
        loggedInUserDao.deleteLoggedInUser()
    }

    companion object {
        const val DESIGNER_NEWS_PREF = "DESIGNER_NEWS_PREF"
        private const val KEY_USER_ID = "KEY_USER_ID"
        private const val KEY_USER_NAME = "KEY_USER_NAME"
        private const val KEY_USER_AVATAR = "KEY_USER_AVATAR"
    }
}
