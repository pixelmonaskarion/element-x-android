/*
 * Copyright (c) 2022 New Vector Ltd
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

package io.element.android.libraries.matrix.api.timeline

import io.element.android.libraries.matrix.api.core.EventId
import io.element.android.libraries.matrix.api.core.TransactionId
import io.element.android.libraries.matrix.api.timeline.item.event.EventTimelineItem
import io.element.android.libraries.matrix.api.timeline.item.virtual.VirtualTimelineItem

sealed interface MatrixTimelineItem {
    data class Event(val uniqueId: Long, val event: EventTimelineItem) : MatrixTimelineItem {
        val eventId: EventId? = event.eventId
        val transactionId: TransactionId? = event.transactionId
    }

    data class Virtual(val uniqueId: Long, val virtual: VirtualTimelineItem) : MatrixTimelineItem
    data object Other : MatrixTimelineItem
}

