package org.android.go.sopt.week1.presentation.home

import android.os.Bundle
import android.view.View
import org.android.go.sopt.R
import org.android.go.sopt.data.Follower
import org.android.go.sopt.databinding.FragmentHomeBinding
import org.android.go.sopt.week1.utill.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var followerAdapter: FollowerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addRepoList()
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter(
            Follower.Header("hajeong's repository")
        )
        binding.rvHome.adapter = followerAdapter
    }

    private fun addRepoList() {
        followerAdapter.submitList(
            listOf(
                Follower.FollowerInfo(
                    1,
                    "김하정",
                    "하정",
                    "https://www.google.co.kr/imgres?imgurl=https%3A%2F%2Fnhim.splf.in%2Fimage%2Facnh%2Fanimal%2FPoppy.png&tbnid=EP83hp1UZlPdfM&vet=12ahUKEwiIl6bSkLv-AhWGeN4KHVO7ASoQMygLegUIARD7AQ..i&imgrefurl=https%3A%2F%2Fanimalcrossing.soopoolleaf.com%2Fko%2Facna%2FPoppy%2F&docid=LX4ZCG2uehMiyM&w=501&h=599&q=%EB%8F%99%EB%AC%BC%EC%9D%98%20%EC%88%B2%20%EC%A3%BC%EB%AF%BC&ved=2ahUKEwiIl6bSkLv-AhWGeN4KHVO7ASoQMygLegUIARD7AQ"
                ),
                Follower.FollowerInfo(
                    2,
                    "황연진",
                    "연진",
                    "https://www.google.co.kr/imgres?imgurl=https%3A%2F%2Fanimalcrossing.soopoolleaf.com%2Fmagnifyingglass_ani.png&tbnid=3e55zBTfKSaY2M&vet=12ahUKEwiPldLzkLv-AhXQUt4KHfAvDj8QMygHegUIARDIAQ..i&imgrefurl=https%3A%2F%2Fanimalcrossing.soopoolleaf.com%2Fko%2Facnh%2Fanimalsearch%2F&docid=lmkLk_vbkZz2vM&w=304&h=479&q=%EB%8F%99%EB%AC%BC%EC%9D%98%20%EC%88%B2%20%EC%A3%BC%EB%AF%BC%20%EC%9D%B4%EB%AF%B8%EC%A7%80&ved=2ahUKEwiPldLzkLv-AhXQUt4KHfAvDj8QMygHegUIARDIAQ"
                ),
                Follower.FollowerInfo(
                    3,
                    "이가은",
                    "가은",
                    "https://www.google.co.kr/imgres?imgurl=https%3A%2F%2Fnhim.splf.in%2Fimage%2Facnh%2Fanimal%2FKetchup.png&tbnid=JUrMq8P3uiCRNM&vet=12ahUKEwiPldLzkLv-AhXQUt4KHfAvDj8QMyhCegQIARBh..i&imgrefurl=https%3A%2F%2Fanimalcrossing.soopoolleaf.com%2Fko%2Facna%2FKetchup%2F&docid=oLMyBGXhOMvOnM&w=380&h=600&q=%EB%8F%99%EB%AC%BC%EC%9D%98%20%EC%88%B2%20%EC%A3%BC%EB%AF%BC%20%EC%9D%B4%EB%AF%B8%EC%A7%80&ved=2ahUKEwiPldLzkLv-AhXQUt4KHfAvDj8QMyhCegQIARBh)"
                ),
                Follower.FollowerInfo(
                    4,
                    "신서현",
                    "서현",
                    "https://www.google.co.kr/url?sa=i&url=http%3A%2F%2Fheumu.blogspot.com%2F2020%2F04%2Fbunnie.html&psig=AOvVaw200fkvb5gZ8wCJcbcfp8JT&ust=1682171929291000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNimlPSQu_4CFQAAAAAdAAAAABAF"
                ),
                Follower.FollowerInfo(
                    4,
                    "김수빈",
                    "수빈",
                    "https://www.google.co.kr/url?sa=i&url=https%3A%2F%2Fnamu.wiki%2Fw%2F%25EB%25A7%2588%25EC%259D%2584%2520%25EC%25A3%25BC%25EB%25AF%25BC&psig=AOvVaw200fkvb5gZ8wCJcbcfp8JT&ust=1682171929291000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNimlPSQu_4CFQAAAAAdAAAAABAK"
                )
            )
        )
    }

    companion object {
        private const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
