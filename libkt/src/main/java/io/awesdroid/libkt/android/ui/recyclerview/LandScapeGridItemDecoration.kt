package io.awesdroid.libkt.android.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * @author Awesdroid
 */
class LandScapeGridItemDecoration: GridItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        getLandScapeItemOffsets(outRect, view, parent.width)
    }
}