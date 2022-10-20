//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import com.example.shoe.databinding.FragmentListingBinding
//import com.example.shoe.model.Shoe
//
//class KemonoAdapter(private val context: Context) : BaseAdapter() {
//    var shoes: List<Shoe> = emptyList()
//
//    override fun getCount(): Int = shoes.size
//
//    override fun getItem(position: Int): Any? = shoes[position]
//
//    override fun getItemId(position: Int): Long = 0
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val binding: FragmentListingBinding
//        if (convertView == null) {
//            binding = FragmentListingBinding.inflate(LayoutInflater.from(context), parent, false)
//            binding.root.tag = binding
//        } else {
//            binding = convertView.tag as FragmentListingBinding
//        }
//        binding. = getItem(position) as Shoe
//        return binding.root
//    }
//}