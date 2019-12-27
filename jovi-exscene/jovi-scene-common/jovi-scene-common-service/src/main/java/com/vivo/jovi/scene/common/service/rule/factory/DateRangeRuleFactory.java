package com.vivo.jovi.scene.common.service.rule.factory;

import com.alibaba.fastjson.JSON;
import com.vivo.jovi.scene.common.activity.rule.AbstractRuleFactory;
import com.vivo.jovi.scene.common.activity.rule.Rule;
import com.vivo.jovi.scene.common.activity.rule.RuleTypeRepository;
import com.vivo.jovi.scene.common.constant.RuleType;
import com.vivo.jovi.scene.common.service.rule.DateRangeRule;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
@Service
public class DateRangeRuleFactory extends AbstractRuleFactory<DateRangeRuleFactory.Config> {
    static {
        RuleTypeRepository.register(DateRangeRule.class, RuleType.DATE_RANGE_RULE);
    }

    protected DateRangeRuleFactory() {
        super(Config.class);
    }

    @Override
    public String getSupportedType() {
        return RuleTypeRepository.getType(DateRangeRule.class);
    }

    @Override
    public Rule apply(Config config) {
        DateRangeRule rule = new DateRangeRule();
        rule.setOrder(config.getOrder());
        rule.setAttenuationDuration(config.getAttenuationDuration());
        rule.setState(config.getState());
        rule.setStartTime(config.getTimeRule().getStartTime());
        rule.setEndTime(config.getTimeRule().getEndTime());
        return rule;
    }

    @Override
    public Config newConfig(String json) {
        return Config.getConfigByJson(json);
    }

    public static class Config{
        private Integer state;
        private Integer order;
        private Integer attenuationDuration;
        private TimeRule timeRule;

        public static Config getConfigByJson(String json){
            Config config = JSON.parseObject(json,Config.class);
            return config;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public TimeRule getTimeRule() {
            return timeRule;
        }

        public void setTimeRule(TimeRule timeRule) {
            this.timeRule = timeRule;
        }

        public Integer getAttenuationDuration() {
            return attenuationDuration;
        }

        public void setAttenuationDuration(Integer attenuationDuration) {
            this.attenuationDuration = attenuationDuration;
        }

        public class TimeRule {
            private Integer type;
            private String holiday;
            private Timestamp startTime;
            private Timestamp endTime;

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public String getHoliday() {
                return holiday;
            }

            public void setHoliday(String holiday) {
                this.holiday = holiday;
            }

            public Timestamp getStartTime() {
                return startTime;
            }

            public void setStartTime(Timestamp startTime) {
                this.startTime = startTime;
            }

            public Timestamp getEndTime() {
                return endTime;
            }

            public void setEndTime(Timestamp endTime) {
                this.endTime = endTime;
            }
        }
    }



}
