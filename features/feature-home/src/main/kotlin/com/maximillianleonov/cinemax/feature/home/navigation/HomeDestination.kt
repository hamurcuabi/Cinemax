/*
 * Copyright 2022 Maximillian Leonov
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

package com.maximillianleonov.cinemax.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maximillianleonov.cinemax.core.ui.common.ContentType
import com.maximillianleonov.cinemax.core.ui.navigation.CinemaxNavigationDestination
import com.maximillianleonov.cinemax.feature.home.HomeRoute

object HomeDestination : CinemaxNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(
    onNavigateToListDestination: (ContentType.List) -> Unit,
    onNavigateToDetailsDestination: (ContentType.Details) -> Unit
) = composable(route = HomeDestination.route) {
    HomeRoute(
        onSeeAllClick = onNavigateToListDestination,
        onMovieClick = { onNavigateToDetailsDestination(ContentType.Details.Movie(it)) },
        onTvShowClick = { onNavigateToDetailsDestination(ContentType.Details.TvShow(it)) }
    )
}
