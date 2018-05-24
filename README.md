# EasyMvp
封装了下简单的mvp,持续更新中
本项目是以最简洁的方式敲代码为初衷.
更新列表:
2018/5/23:
新建 mvp 架构
2018/5/24:
封装retrofit 2.0+rxjava 加入mvp架构
 
目前实现起来如mvc一般简单,所有基类全部通用.如个别需求可增加presenter ,model.
部分 代码:
public class MvpdemoActivity extends BaseActivity {

    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showData(int tag, Object data) {
        super.showData(tag, data);
        List<GetMessageCenterBean> da = (List<GetMessageCenterBean>) data;
        switch (tag) {
            case 0:
                text.setText("接口0" + da.get(0).getTitle());
                break;
            case 1:
                text.setText("接口1" + da.get(0).getTitle());
                break;
            case 2:
                text.setText("接口2" + da.get(0).getTitle());
                break;
            default:
        }
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                presenter.getData(0, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
            case R.id.btn2:
                presenter.getData(1, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
            case R.id.btn3:
                presenter.getData(2, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
                default:
        }
    }
}
